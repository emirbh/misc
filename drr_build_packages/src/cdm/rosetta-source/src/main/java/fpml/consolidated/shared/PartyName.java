package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.PartyNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for the legal name of an organization.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for the legal name of an organization.
 *
 */
@RosettaDataType(value="PartyName", builder=PartyName.PartyNameBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyName", model="fpml", builder=PartyName.PartyNameBuilderImpl.class, version="2.1.1")
public interface PartyName extends RosettaModelObject {

	PartyNameMeta metaData = new PartyNameMeta();

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
	String getPartyNameScheme();

	/*********************** Build Methods  ***********************/
	PartyName build();
	
	PartyName.PartyNameBuilder toBuilder();
	
	static PartyName.PartyNameBuilder builder() {
		return new PartyName.PartyNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyName> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyName> getType() {
		return PartyName.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("partyNameScheme"), String.class, getPartyNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyNameBuilder extends PartyName, RosettaModelObjectBuilder {
		PartyName.PartyNameBuilder setValue(String value);
		PartyName.PartyNameBuilder setPartyNameScheme(String partyNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("partyNameScheme"), String.class, getPartyNameScheme(), this);
		}
		

		PartyName.PartyNameBuilder prune();
	}

	/*********************** Immutable Implementation of PartyName  ***********************/
	class PartyNameImpl implements PartyName {
		private final String value;
		private final String partyNameScheme;
		
		protected PartyNameImpl(PartyName.PartyNameBuilder builder) {
			this.value = builder.getValue();
			this.partyNameScheme = builder.getPartyNameScheme();
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
		@RosettaAttribute("partyNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyNameScheme")
		public String getPartyNameScheme() {
			return partyNameScheme;
		}
		
		@Override
		public PartyName build() {
			return this;
		}
		
		@Override
		public PartyName.PartyNameBuilder toBuilder() {
			PartyName.PartyNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyName.PartyNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPartyNameScheme()).ifPresent(builder::setPartyNameScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyNameScheme, _that.getPartyNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyNameScheme != null ? partyNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyName {" +
				"value=" + this.value + ", " +
				"partyNameScheme=" + this.partyNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyName  ***********************/
	class PartyNameBuilderImpl implements PartyName.PartyNameBuilder {
	
		protected String value;
		protected String partyNameScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyNameScheme")
		public String getPartyNameScheme() {
			return partyNameScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public PartyName.PartyNameBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("partyNameScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyNameScheme")
		@Override
		public PartyName.PartyNameBuilder setPartyNameScheme(String _partyNameScheme) {
			this.partyNameScheme = _partyNameScheme == null ? null : _partyNameScheme;
			return this;
		}
		
		@Override
		public PartyName build() {
			return new PartyName.PartyNameImpl(this);
		}
		
		@Override
		public PartyName.PartyNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyName.PartyNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPartyNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyName.PartyNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyName.PartyNameBuilder o = (PartyName.PartyNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPartyNameScheme(), o.getPartyNameScheme(), this::setPartyNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyNameScheme, _that.getPartyNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyNameScheme != null ? partyNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyNameBuilder {" +
				"value=" + this.value + ", " +
				"partyNameScheme=" + this.partyNameScheme +
			'}';
		}
	}
}
