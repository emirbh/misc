package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.OrganizationCharacteristicMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A characteristic of an organization used in declaring an end-user exception.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A characteristic of an organization used in declaring an end-user exception.
 *
 */
@RosettaDataType(value="OrganizationCharacteristic", builder=OrganizationCharacteristic.OrganizationCharacteristicBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OrganizationCharacteristic", model="fpml", builder=OrganizationCharacteristic.OrganizationCharacteristicBuilderImpl.class, version="2.1.1")
public interface OrganizationCharacteristic extends RosettaModelObject {

	OrganizationCharacteristicMeta metaData = new OrganizationCharacteristicMeta();

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
	String getOrganizationCharacteristicScheme();

	/*********************** Build Methods  ***********************/
	OrganizationCharacteristic build();
	
	OrganizationCharacteristic.OrganizationCharacteristicBuilder toBuilder();
	
	static OrganizationCharacteristic.OrganizationCharacteristicBuilder builder() {
		return new OrganizationCharacteristic.OrganizationCharacteristicBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrganizationCharacteristic> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OrganizationCharacteristic> getType() {
		return OrganizationCharacteristic.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("organizationCharacteristicScheme"), String.class, getOrganizationCharacteristicScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrganizationCharacteristicBuilder extends OrganizationCharacteristic, RosettaModelObjectBuilder {
		OrganizationCharacteristic.OrganizationCharacteristicBuilder setValue(String value);
		OrganizationCharacteristic.OrganizationCharacteristicBuilder setOrganizationCharacteristicScheme(String organizationCharacteristicScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("organizationCharacteristicScheme"), String.class, getOrganizationCharacteristicScheme(), this);
		}
		

		OrganizationCharacteristic.OrganizationCharacteristicBuilder prune();
	}

	/*********************** Immutable Implementation of OrganizationCharacteristic  ***********************/
	class OrganizationCharacteristicImpl implements OrganizationCharacteristic {
		private final String value;
		private final String organizationCharacteristicScheme;
		
		protected OrganizationCharacteristicImpl(OrganizationCharacteristic.OrganizationCharacteristicBuilder builder) {
			this.value = builder.getValue();
			this.organizationCharacteristicScheme = builder.getOrganizationCharacteristicScheme();
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
		@RosettaAttribute("organizationCharacteristicScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("organizationCharacteristicScheme")
		public String getOrganizationCharacteristicScheme() {
			return organizationCharacteristicScheme;
		}
		
		@Override
		public OrganizationCharacteristic build() {
			return this;
		}
		
		@Override
		public OrganizationCharacteristic.OrganizationCharacteristicBuilder toBuilder() {
			OrganizationCharacteristic.OrganizationCharacteristicBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrganizationCharacteristic.OrganizationCharacteristicBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getOrganizationCharacteristicScheme()).ifPresent(builder::setOrganizationCharacteristicScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganizationCharacteristic _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(organizationCharacteristicScheme, _that.getOrganizationCharacteristicScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (organizationCharacteristicScheme != null ? organizationCharacteristicScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganizationCharacteristic {" +
				"value=" + this.value + ", " +
				"organizationCharacteristicScheme=" + this.organizationCharacteristicScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OrganizationCharacteristic  ***********************/
	class OrganizationCharacteristicBuilderImpl implements OrganizationCharacteristic.OrganizationCharacteristicBuilder {
	
		protected String value;
		protected String organizationCharacteristicScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("organizationCharacteristicScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("organizationCharacteristicScheme")
		public String getOrganizationCharacteristicScheme() {
			return organizationCharacteristicScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public OrganizationCharacteristic.OrganizationCharacteristicBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("organizationCharacteristicScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("organizationCharacteristicScheme")
		@Override
		public OrganizationCharacteristic.OrganizationCharacteristicBuilder setOrganizationCharacteristicScheme(String _organizationCharacteristicScheme) {
			this.organizationCharacteristicScheme = _organizationCharacteristicScheme == null ? null : _organizationCharacteristicScheme;
			return this;
		}
		
		@Override
		public OrganizationCharacteristic build() {
			return new OrganizationCharacteristic.OrganizationCharacteristicImpl(this);
		}
		
		@Override
		public OrganizationCharacteristic.OrganizationCharacteristicBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganizationCharacteristic.OrganizationCharacteristicBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getOrganizationCharacteristicScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganizationCharacteristic.OrganizationCharacteristicBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrganizationCharacteristic.OrganizationCharacteristicBuilder o = (OrganizationCharacteristic.OrganizationCharacteristicBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getOrganizationCharacteristicScheme(), o.getOrganizationCharacteristicScheme(), this::setOrganizationCharacteristicScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganizationCharacteristic _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(organizationCharacteristicScheme, _that.getOrganizationCharacteristicScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (organizationCharacteristicScheme != null ? organizationCharacteristicScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganizationCharacteristicBuilder {" +
				"value=" + this.value + ", " +
				"organizationCharacteristicScheme=" + this.organizationCharacteristicScheme +
			'}';
		}
	}
}
