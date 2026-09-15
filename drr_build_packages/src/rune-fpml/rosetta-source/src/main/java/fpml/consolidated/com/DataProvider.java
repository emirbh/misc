package fpml.consolidated.com;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.com.meta.DataProviderMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Specify as applicable. Parties may wish to refer to the state meteorological authority in a particular location or to an exchange or other third party data provider. Parties may find the definitions in the Commodity Definitions useful as a means of identifying potential Data Providers.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Specify as applicable. Parties may wish to refer to the state meteorological authority in a particular location or to an exchange or other third party data provider. Parties may find the definitions in the Commodity Definitions useful as a means of identifying potential Data Providers.
 *
 */
@RosettaDataType(value="DataProvider", builder=DataProvider.DataProviderBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DataProvider", model="fpml", builder=DataProvider.DataProviderBuilderImpl.class, version="2.1.1")
public interface DataProvider extends RosettaModelObject {

	DataProviderMeta metaData = new DataProviderMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getWeatherDataProviderScheme();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();

	/*********************** Build Methods  ***********************/
	DataProvider build();
	
	DataProvider.DataProviderBuilder toBuilder();
	
	static DataProvider.DataProviderBuilder builder() {
		return new DataProvider.DataProviderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DataProvider> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DataProvider> getType() {
		return DataProvider.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("weatherDataProviderScheme"), String.class, getWeatherDataProviderScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DataProviderBuilder extends DataProvider, RosettaModelObjectBuilder {
		DataProvider.DataProviderBuilder setValue(String value);
		DataProvider.DataProviderBuilder setWeatherDataProviderScheme(String weatherDataProviderScheme);
		DataProvider.DataProviderBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("weatherDataProviderScheme"), String.class, getWeatherDataProviderScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		DataProvider.DataProviderBuilder prune();
	}

	/*********************** Immutable Implementation of DataProvider  ***********************/
	class DataProviderImpl implements DataProvider {
		private final String value;
		private final String weatherDataProviderScheme;
		private final String id;
		
		protected DataProviderImpl(DataProvider.DataProviderBuilder builder) {
			this.value = builder.getValue();
			this.weatherDataProviderScheme = builder.getWeatherDataProviderScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("weatherDataProviderScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherDataProviderScheme")
		public String getWeatherDataProviderScheme() {
			return weatherDataProviderScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public DataProvider build() {
			return this;
		}
		
		@Override
		public DataProvider.DataProviderBuilder toBuilder() {
			DataProvider.DataProviderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DataProvider.DataProviderBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getWeatherDataProviderScheme()).ifPresent(builder::setWeatherDataProviderScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DataProvider _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherDataProviderScheme, _that.getWeatherDataProviderScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherDataProviderScheme != null ? weatherDataProviderScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DataProvider {" +
				"value=" + this.value + ", " +
				"weatherDataProviderScheme=" + this.weatherDataProviderScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of DataProvider  ***********************/
	class DataProviderBuilderImpl implements DataProvider.DataProviderBuilder {
	
		protected String value;
		protected String weatherDataProviderScheme;
		protected String id;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("weatherDataProviderScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherDataProviderScheme")
		public String getWeatherDataProviderScheme() {
			return weatherDataProviderScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public DataProvider.DataProviderBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("weatherDataProviderScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherDataProviderScheme")
		@Override
		public DataProvider.DataProviderBuilder setWeatherDataProviderScheme(String _weatherDataProviderScheme) {
			this.weatherDataProviderScheme = _weatherDataProviderScheme == null ? null : _weatherDataProviderScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DataProvider.DataProviderBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public DataProvider build() {
			return new DataProvider.DataProviderImpl(this);
		}
		
		@Override
		public DataProvider.DataProviderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DataProvider.DataProviderBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getWeatherDataProviderScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DataProvider.DataProviderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DataProvider.DataProviderBuilder o = (DataProvider.DataProviderBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getWeatherDataProviderScheme(), o.getWeatherDataProviderScheme(), this::setWeatherDataProviderScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DataProvider _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherDataProviderScheme, _that.getWeatherDataProviderScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherDataProviderScheme != null ? weatherDataProviderScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DataProviderBuilder {" +
				"value=" + this.value + ", " +
				"weatherDataProviderScheme=" + this.weatherDataProviderScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
