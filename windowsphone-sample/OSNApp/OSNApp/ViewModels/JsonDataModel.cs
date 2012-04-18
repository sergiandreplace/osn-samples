using System;
using System.Runtime.Serialization;
using System.Xml.Serialization;
using System.ComponentModel;
using System.Collections.Generic;


namespace OSNApp.ViewModels
{
    [DataContract]
    public class JsonDataModel
    {
        public JsonDataModel() { }

        [DataMember(Name = "entry")]
        public EntryJson EntryItem { get; set; }
        
    }

    /// <summary>
    ///This class is just a simple container used to retrieve an entry from a json file
    /// </summary>
    [DataContract]
    public class EntryJson : INotifyPropertyChanged
    {
        /// <summary>
        /// Id of service
        /// </summary>
        [DataMember(Name = "id")]
        public long Id { get; set; }

        /// <summary>
        /// Specify from where the data comes from
        /// </summary>
        [DataMember(Name = "source_id")]
        public string SourceId { get; set; }

        /// <summary>
        /// When the data was collected
        /// </summary>
        [DataMember(Name = "date")]
        public string Date { get; set; }

        /// <summary>
        /// content of the entry. A simple value can only consist of a string without structure. 
        /// For instance, a temperature service with just one value. 
        /// Complex values contain structured data of multiple information sources. 
        /// For example, a service that gives information about the motorway cameras. 
        /// In the value field is indicated all the information of the cameras of the motorway in a xml structure.
        /// </summary>
        [DataMember(Name = "value")]
        public string Value { get; set; }

        /// <summary>
        /// Units of the value
        /// </summary>
        [DataMember(Name = "unit")]
        public string Unit { get; set; }

        /// <summary>
        /// Additional information that might be useful and that it's not in the value field
        /// </summary>
        [DataMember(Name = "extra_info")]
        public string ExtraInfo { get; set; }


        [DataMember(Name = "latitude")]
        public double Latitude { get; set; }


        [DataMember(Name = "longitude")]
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
