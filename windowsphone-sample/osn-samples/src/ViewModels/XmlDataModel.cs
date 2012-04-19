using System;
using System.Xml.Serialization;
using System.ComponentModel;
using System.Collections.Generic;

using System.Xml;

using System.Runtime.Serialization;


namespace OSNApp.ViewModels
{
    //It is Very important to copy in here the Namespace of your XML File
    [XmlRoot(ElementName = "entry", Namespace = "http://www.upf.edu/opencities/datamodel")]
    public class XmlDataModel 
    {
        public XmlDataModel() { }

        [XmlElement("id")]
        public long Id { get; set; }


        [XmlElement("source_id")]
        public string SourceId { get; set; }


        [XmlElement("date")]
        public string Date { get; set; }


        [XmlElement("value")]
        public string Value { get; set; }


        [XmlElement("unit")]
        public string Unit { get; set; }


        [XmlElement("extra_info")]
        public string ExtraInfo { get; set; }


        [XmlElement("latitude")]
        public double Latitude { get; set; }


        [XmlElement("longitude")]
        public double Longitude { get; set; }

        //This is for Binding the Data.
        public event PropertyChangedEventHandler PropertyChanged;

        public void NotifyChanges(string propertyName)
        {
            if (propertyName != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }
    }
}
