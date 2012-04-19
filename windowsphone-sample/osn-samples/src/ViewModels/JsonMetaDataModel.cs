using System;
using System.Runtime.Serialization;
using System.Xml.Serialization;
using System.ComponentModel;
using System.Collections.Generic;

namespace OSNApp.ViewModels
{
    [DataContract]
    public class JsonMetaDataModel
    {
        [DataMember(Name = "service")]
        public Service ServiceItem { get; set; }
    }

    [DataContract]
    public class Service : INotifyPropertyChanged
    {
        private List<string> tags = new List<string>();
        private String tagsListed;
        /// <summary>
        /// This is the unique identifier of the service, and is assigned by the OSN
	    /// platform when the service is about to be created. This identifier cannot
	    /// be modified once the service is created, so this identifier will be the
        /// only reference the data consumers will have. Furthermore, there can exist
	    /// multiple services with the same attributes, including the name. However,
	    /// never two services with the same Service ID.
        /// </summary>
        [DataMember(Name = "id")]
        public long Id { get; set; }

        [DataMember(Name = "email")]
        public string Email { get; set; }

        /// <summary>
        /// In the service name is described in a high level what the service is
	    /// about. It must be avoided using technical names like: "SNF XGF23". This
	    /// name gives no information to the consumers of what the service is about.
	    /// An example of a good name for a temperature service would be:
	    /// "BCN Temperature station 23".
        /// </summary>
        [DataMember(Name = "name")]
        public string Name { get; set; }

        [DataMember(Name = "author")]
        public string Author { get; set; }

        /// <summary>
        /// In the description attribute, it can be included as much information as you want about the service. However, you must avoid repeating information that it is already in other attributes of the service, for instance, the update period. 
        /// There is no length limit for this field, but think that the information contained in it must be relevant for the consumers of the service. Do not specify technical aspects of the sensor or the organization that provides the service.
        /// An example of something that could interest the data consumers, and can be included in this field, is for how long this data or service is going to be available. If you have a sensor network that measures the state of the beaches, this might only be available during a periods of months.
        /// Because during the summer it might not make sense to send information about the state of the beaches.
        /// </summary>
        [DataMember(Name = "description")]
        public string Description { get; set; }

        /// <summary>
        /// Here is where is specified the data periodicity on the service. 
        /// Remember to include the units and not only a number. E.g: 15 minutes. 
        /// If your service is based on events you can also specify this in here writing "Based on Events". 
        /// In this case it is recommended to see the Twitter section.
        /// </summary>
        [DataMember(Name = "update_period")]
        public string UpdatePeriod { get; set; }

        /// <summary>
        ///Here is where is specified to which group a service will belong to. 
        ///To ease the search by group it, there is a predefined list of group that match the most visited areas within the city council.
        /// <ul>
        /// <li>Arts and Recreation</li>
        /// <li>Business Enterprise, Economics, and Trade</li>
        /// <li>City Budget: Revenues & Expenditures</li>
        /// <li>City Portal Web Statistics</li>
        /// <li>Construction, Housing, and Public Works</li>
        /// <li>Crime and Community Safety</li>
        /// <li>Demographics</li>
        /// <li>Education</li>
        /// <li>Election</li>
        /// <li>Emergency Services</li>
        /// <li>Energy and Utilities</li>
        /// <li>Environment, Geography and Meteorological</li>
        /// <li>Health and Disability</li>
        /// <li>Labor Force and Employment Market</li>
        /// <li>Law Enforcement, Courts, and Prisons</li>
        /// <li>Political</li>
        /// <li>Tourism</li>
        ///<li>Urban Transport</li>
        ///<li>Others</li>
        ///</ul>
        /// </summary>
        [DataMember(Name = "group")]
        public string Group { get; set; }

        /// <summary>
        /// In the URL you can specify the web page of your organization, where the consumer might find further information about the service.
        /// </summary>
        [DataMember(Name = "url")]
        public string Url { get; set; }

        /// <summary>
        ///
        /// This attributes contains the license for the provided data. A list of the
        /// most common licenses is provided, from which the Creative Commons is the
        /// recommended one according to the spirit of the project.
        /// 
        /// Due to legal reasons, once the service is created, it will not be
        /// possible to change the type of license. In case that you do not want to
        /// provide any license, select "License Not Specified".
        /// <ul>
        /// <li>Apache Software License http://www.apache.org/licenses/</li>
        /// <li>Apache License, 2.0</li>
        /// <li>Computer Associates Trusted Open Source License 1.1</li>
        /// <li>Creative Commons Attribution</li>
        /// <li>Creative Commons Share-Alike</li>
        /// <li>Creative Commons Non-Commercial (Any)</li>
        /// <li>Creative Commons CCZero</li>
        /// <li>Eclipse Public License</li>
        /// <li>GNU Free Documentation License</li>
        /// <li>GNU General Public License (GPL)</li>
        /// <li>GNU General Public License version 3.0 (GPLv3)</li>
        /// <li>MIT license</li>
        /// <li>Mozilla Public License 1.0 (MPL)</li>
        /// <li>Mozilla Public License 1.1 (MPL)</li>
        /// <li>License Not Specified</li>
        /// <li>Open Data Commons Open Database License (ODbL)</li>
        /// <li>Open Data Commons Public Domain Dedication and Licence (PDDL)</li>
        /// <li>W3C License</li>
        /// </ul>
        /// </summary>
        [DataMember(Name = "license")]
        public string License { get; set; }

        /// <summary>
        ///The geo-localization indicates the point where the sensor is located.
        ///There is also the possibility that this value indicates the value, for example, of a road. 
        /// A single point is identified by one latitude and one longitude.
        /// </summary>
        [DataMember(Name = "latitude")]
        public double Latitude { get; set; }

        /// <summary>
        /// The geo-localization indicates the point where the sensor is located.
        /// There is also the possibility that this value indicates the value, for example, of a road.
        /// A single point is identified by one latitude and one longitude.
        /// </summary>
        [DataMember(Name = "longitude")]
        public double Longitude { get; set; }

        /// <summary>
        /// The OSN Platform offers you the possibility of registering services
        /// adding Twitter notifications. You just need to create a new Twitter
        /// account for your service and enter into the Twitter configuration. Then
        /// create a new application and when you finish please enter into the
        /// Developers section.
        /// </summary>
        [DataMember(Name = "twitter_account")]
        public string TwitterAccount { get; set; }

        [DataMember(Name = "resource")]
        public List<Resource> Resource { get; set; }

        /// <summary>
        /// Services do not follow a hierarchical structure. Services cannot contain other services, and the way to organize the services is with tags.
        /// Each service can contain as many tags as you want, and all of them are treated equally. 
        /// However, when writing the tags you should think about the purpose of each one. We recommend to use three types of tags when registering a service:
        /// <ul>
        /// <li>Type tag: indicate the type of data the service is measuring.</li>
        /// <li>Location tag: the area where the service belongs to. You can include different tags specifying the location. For example: Spain, Catalonia,
        /// Barcelona, Poble Nou.</li>
        /// <li>Owner tag: These are suitable if you are interested that the consumer can obtain a list of the different services that you provide.
        /// If you include a tag with "Barcelona City Council", the consumers might be able to list all your services.</li> 
        /// </summary>
        [DataMember(Name = "tag")]
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

        [DataMember(Name = "extras")]
        public Extras Extras { get; set; }

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
    
    /// <summary>
    /// Each one of the urls pointed by a service
    /// </summary>
    [DataContract]
    public class Resource
    {

        [DataMember(Name = "url")]
        public String Url { get; set; }

        [DataMember(Name = "format")]
        public String Format { get; set; }

        [DataMember(Name = "description")]
        public String Description { get; set; }
    }

    /// <summary>
    /// Extra information contained in the service
    /// </summary>
    [DataContract]
    public class Extras
    {

        [DataMember(Name = "geographical_coverage")]
        public string GeographicalCoverage { get; set; }

        [DataMember(Name = "geographical_granularity")]
        public string GeographicalGranularity { get; set; }

        [DataMember(Name = "temporal_coverage-from")]
        public string TemporalCoverageFrom { get; set; }

        [DataMember(Name = "temporal_coverage-to")]
        public string TemporalCoverageTo { get; set; }

        [DataMember(Name = "temporal_granularity")]
        public string TemporalGranularity { get; set; }

        [DataMember(Name = "date_released")]
        public string DateReleased { get; set; }

        [DataMember(Name = "date_updated")]
        public string DateUpdated { get; set; }
    }
}
