using System;
using System.Xml.Serialization;
using System.ComponentModel;
using System.Collections.Generic;

namespace OSNApp.ViewModels
{
    [XmlRoot(ElementName = "service", Namespace = "http://www.upf.edu/opencities/datamodel")]
    public class XmlMetaDataModel
    {
        private List<string> tags = new List<string>();
        private String tagsListed;

        [XmlElement(  "id")]
        public long Id { get; set; }

        [XmlElement(  "email")]
        public string Email { get; set; }

        [XmlElement("name")]
        public string Name { get; set; }

        [XmlElement(  "author")]
        public string Author { get; set; }

        [XmlElement(  "description")]
        public string Description { get; set; }

        [XmlElement(  "update_period")]
        public string UpdatePeriod { get; set; }

        [XmlElement(  "group")]
        public string Group { get; set; }

        [XmlElement(  "url")]
        public string Url { get; set; }

        [XmlElement(  "license")]
        public string License { get; set; }

        [XmlElement(  "latitude")]
        public double Latitude { get; set; }

        [XmlElement(  "longitude")]
        public double Longitude { get; set; }

        [XmlElement(  "twitter_account")]
        public string TwitterAccount { get; set; }

        [XmlElement(  "resource")]
        public List<XmlResource> Resource { get; set; }

        [XmlElement(  "tag")]
        public List<string> Tag { get { return tags; } set { this.tags = value; } }

        public String Tags
        {
            get
            {
                foreach (String str in tags)
                    tagsListed += str + ", ";

                return tagsListed;
            }
            
        }

        [XmlElement(  "extras")]
        public XmlExtras Extras { get; set; }

        //This is for Binding the Data.
        public event PropertyChangedEventHandler PropertyChanged;

        public void NotifyChanges(string property)
        {
            if (property != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(property));
            }
        }
    }

    
    public class XmlResource
    {

        [XmlElement(  "url")]
        public String Url { get; set; }

        [XmlElement(  "format")]
        public String Format { get; set; }

        [XmlElement(  "description")]
        public String Description { get; set; }
    }

    
    public class XmlExtras
    {

        [XmlElement(  "geographical_coverage")]
        public string GeographicalCoverage { get; set; }

        [XmlElement(  "geographical_granularity")]
        public string GeographicalGranularity { get; set; }

        [XmlElement(  "temporal_coverage-from")]
        public string TemporalCoverageFrom { get; set; }

        [XmlElement(  "temporal_coverage-to")]
        public string TemporalCoverageTo { get; set; }

        [XmlElement(  "temporal_granularity")]
        public string TemporalGranularity { get; set; }

        [XmlElement(  "date_released")]
        public string DateReleased { get; set; }

        [XmlElement(  "date_updated")]
        public string DateUpdated { get; set; }
    }
}
