using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;
using Microsoft.Phone.Controls;


using System.IO;
using System.Text;
using OSNApp.ViewModels;
using System.Runtime.Serialization;
using System.Xml.Serialization;
using System.Xml;

namespace OSNApp
{
    public partial class MainPage : PhoneApplicationPage
    {

        private String stringHttpRequest { get; set; }
        private String URLJsonMetaData = "http://193.145.50.132/OSN/rest/service/getService/1324402390199000.json";
        private String URLJsonOpenData = "http://193.145.50.132/OSN/rest/service/getLastEntry/1324402390199000.json";
        private String URLXmlMetaData = "http://193.145.50.132/OSN/rest/service/getService/1324402390199000.xml";
        private String URLXmlOpenData = "http://193.145.50.132/OSN/rest/service/getLastEntry/1324402390199000.xml";

        // Constructor
        public MainPage()
        {
            InitializeComponent();

            // Set the data context of the listbox control to the sample data
            this.Loaded += new RoutedEventHandler(MainPage_Loaded);
        }

        // Load data for the ViewModel Items
        private void MainPage_Loaded(object sender, RoutedEventArgs e)
        {            
            //JSON Info.
            //MetaData
            downloadJSON(URLJsonMetaData, true);
            //OpenData
            downloadJSON(URLJsonOpenData, false);

        }

        //**************************************************************************
        //**************** Download any JSON from an URL and Parse it **************
        //**************************************************************************
        /// <summary>
        /// An example for downloading JSON data from an URL in an Asyncrhonous mode.
        /// </summary>
        /// <param name="url">URL of JSON object</param>
        /// <param name="metaData">Parameter to differentiate between resquesting MetaData or service data</param>
        public void downloadJSON(String url, bool metaData)
        {
            WebClient httpRequest = new WebClient();
            if (metaData)
                httpRequest.OpenReadCompleted += new OpenReadCompletedEventHandler(dowloandJSONMetaDataComplete);
            else
                httpRequest.OpenReadCompleted += new OpenReadCompletedEventHandler(dowloandJSONOpenDataComplete);

            httpRequest.OpenReadAsync(new Uri(url));
        }

        private void dowloandJSONOpenDataComplete(object sender, OpenReadCompletedEventArgs e)
        {
            if (e.Error == null)
            {
                StreamReader stm = new StreamReader(e.Result);
                try
                {
                    String str = stm.ReadToEnd();
                    
                    JsonDataModel jDataParser = new JsonDataModel();
                    jDataParser = DeserializeJSON<JsonDataModel>(str);
                    //Binding data
                    this.gridOpenData.DataContext = jDataParser.EntryItem;
                    //Binding data to the Popup
                    gridPopup.DataContext = jDataParser.EntryItem;
                    stm.Close();
                }
                catch (Exception)
                {
                }

            }
        }
        private void dowloandJSONMetaDataComplete(object sender, OpenReadCompletedEventArgs e)
        {
            if (e.Error == null)
            {
                StreamReader stm = new StreamReader(e.Result);
                try
                {
                    String str = stm.ReadToEnd();
                    JsonMetaDataModel jMetaDataParser = new JsonMetaDataModel();
                    jMetaDataParser = DeserializeJSON<JsonMetaDataModel>(str);
                    this.gridMetaData.DataContext = jMetaDataParser.ServiceItem;
                    stm.Close();
                }
                catch (Exception)
                {
                }

            }
        }
        /// <summary>
        /// Deserializes an object from a UTF-8 encoded JSON string.
        /// </summary>
        /// <typeparam name="T">type of object to deserialize as</typeparam>
        /// <param name="json">UTF-8 encoded JSON string</param>
        /// <returns>deserialized object</returns>
        public static T DeserializeJSON<T>(string json)
        {
            MemoryStream ms = new MemoryStream(Encoding.UTF8.GetBytes(json));
            System.Runtime.Serialization.Json.DataContractJsonSerializer serializer = new System.Runtime.Serialization.Json.DataContractJsonSerializer(typeof(T));
            T obj = (T)serializer.ReadObject(ms);
            //Remember to Close MemoryStream
            ms.Close();
            ms.Dispose();
            return obj;
        }

        //**************************************************************************
        //**************** Download any XML from an URL and Parse it **************
        //**************************************************************************
        public void downloadXML(String url, bool metaData)
        {
            WebClient httpRequest = new WebClient();
            if (metaData)
                httpRequest.OpenReadCompleted += new OpenReadCompletedEventHandler(dowloandXMLMetaDataComplete);
            else
                httpRequest.OpenReadCompleted += new OpenReadCompletedEventHandler(dowloandXMLOpenDataComplete);

            httpRequest.OpenReadAsync(new Uri(url));
        }

        private void dowloandXMLOpenDataComplete(object sender, OpenReadCompletedEventArgs e)
        {
            if (e.Error == null)
            {
                StreamReader stm = new StreamReader(e.Result);
                try
                {
                    XmlDataModel xDataParser = new XmlDataModel();
                    xDataParser = Deserialize<XmlDataModel>(e.Result, typeof(XmlDataModel));
                    gridOpenData.DataContext = xDataParser;
                    gridPopup.DataContext = xDataParser;
                    stm.Close();
                }
                catch (Exception)
                {
                }

            }
        }

        private void dowloandXMLMetaDataComplete(object sender, OpenReadCompletedEventArgs e)
        {
            if (e.Error == null)
            {
                StreamReader stm = new StreamReader(e.Result);
                try
                {
                    XmlMetaDataModel xMetaDataParser = new XmlMetaDataModel();
                    xMetaDataParser = Deserialize<XmlMetaDataModel>(e.Result, typeof(XmlMetaDataModel));
                    this.gridMetaData.DataContext = xMetaDataParser;
                    stm.Close();
                }
                catch (Exception)
                {
                }

            }
        }
        
        /// <summary>
        /// Deserializes an object from a XML stream.
        /// </summary>
        /// <typeparam name="T">type of object to deserialize as</typeparam>
        /// <param name="streamObject">Xml Data stream</param>
        /// <param name="serializedObjectType">type of object to deserialize</param>
        /// <returns>deserialized object</returns>
        public static T Deserialize<T>(Stream streamObject, Type serializedObjectType)
        {
            XmlSerializer serializer = new XmlSerializer(serializedObjectType);
            return (T)serializer.Deserialize(streamObject);
        }

        //**************************************************************************
        //**************************************************************************
        //**************************************************************************
        private void btnJson_Click(object sender, RoutedEventArgs e)
        {
            //Requesting type
            //MetaData
            downloadJSON(URLJsonMetaData, true);
            //OpenData
            downloadJSON(URLJsonOpenData, false);
        }

        private void btnXml_Click(object sender, RoutedEventArgs e)
        {
            //Requesting type
            //MetaData
            downloadXML(URLXmlMetaData, true);
            //XML OpenData
            downloadXML(URLXmlOpenData, false);
        }

        private void btnShowValue_Click(object sender, RoutedEventArgs e)
        {
            if (popup.IsOpen)
                popup.IsOpen = false;
            else
                popup.IsOpen = true;
        }
        protected override void OnBackKeyPress(System.ComponentModel.CancelEventArgs e)
        {
            base.OnBackKeyPress(e);
            if (popup.IsOpen){
                e.Cancel = true;
                popup.IsOpen = false;
            }
            
                
        }
    }
}