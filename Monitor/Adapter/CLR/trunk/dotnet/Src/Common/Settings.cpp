#include "../Common/Settings.h"

Settings::Settings() :
  InMemoryInstanceMap(false),
  CacheAtStartUp(false),
  MinNumberOfModules(0),
  typesOfInterest(CStringSet()),
  modulesToIgnore(CStringSet())
{
  readSettings();
}

Settings::~Settings()
{
  typesOfInterest.clear();
  modulesToIgnore.clear();
}

Settings* Settings::instance = 0;

Settings* Settings::theInstance()
{
  if(!Settings::instance)
    Settings::instance = new Settings();
  return Settings::instance;
}

void Settings::release()
{
  this->~Settings();
}

void Settings::readSettings()
{
  pugi::xml_document doc;
  pugi::xml_parse_result res;
  
  if(InfoBoard::theInstance()->AppType == ADAPTER)
    res = doc.load_file(_T("lib/plugins/monitor_adapter/clr_adapter_settings.xml"));
  else
    res = doc.load_file(_T("../../Doc/clr_adapter_settings.xml"));

  if(!res)
    std::cerr << _T("Settings: ") <<  res.description() << std::endl;

  MinNumberOfModules = doc.child("Settings").child("TypeInfoHelper").attribute("MinNumberOfModules").as_uint();
  InMemoryInstanceMap    = doc.child("Settings").child("ObjectInfoHelper").attribute("InMemoryInstanceMap").as_bool();
  CacheAtStartUp    = doc.child("Settings").child("ObjectInfoHelper").attribute("CacheAtStartUp").as_bool();

  pugi::xml_node types = doc.child("Settings").child("TypesOfInterest");
  for (pugi::xml_node type = types.child("TypeOfInterest"); type; type = type.next_sibling("TypeOfInterest"))
  {
    typesOfInterest.insert(type.attribute("Name").as_string());
  }

  pugi::xml_node modules = doc.child("Settings").child("ModulesToIgnore");
  for (pugi::xml_node module = modules.child("ModuleToIgnore"); module; module = module.next_sibling("ModuleToIgnore"))
  {
    modulesToIgnore.insert(module.attribute("Name").as_string());
  }

  // some verification
  if(CacheAtStartUp && !InMemoryInstanceMap)
  {
    InMemoryInstanceMap = true;
    std::cerr << _T("Settings: if CacheAtStartUp is true InMemoryInstanceMap should be true, too.") << std::endl;
  }
}