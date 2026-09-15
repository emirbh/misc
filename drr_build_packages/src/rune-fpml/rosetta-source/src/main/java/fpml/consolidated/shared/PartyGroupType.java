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
import fpml.consolidated.shared.meta.PartyGroupTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for party group classification.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for party group classification.
 *
 */
@RosettaDataType(value="PartyGroupType", builder=PartyGroupType.PartyGroupTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyGroupType", model="fpml", builder=PartyGroupType.PartyGroupTypeBuilderImpl.class, version="2.1.1")
public interface PartyGroupType extends RosettaModelObject {

	PartyGroupTypeMeta metaData = new PartyGroupTypeMeta();

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
	String getPartyGroupTypeScheme();

	/*********************** Build Methods  ***********************/
	PartyGroupType build();
	
	PartyGroupType.PartyGroupTypeBuilder toBuilder();
	
	static PartyGroupType.PartyGroupTypeBuilder builder() {
		return new PartyGroupType.PartyGroupTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyGroupType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyGroupType> getType() {
		return PartyGroupType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("partyGroupTypeScheme"), String.class, getPartyGroupTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyGroupTypeBuilder extends PartyGroupType, RosettaModelObjectBuilder {
		PartyGroupType.PartyGroupTypeBuilder setValue(String value);
		PartyGroupType.PartyGroupTypeBuilder setPartyGroupTypeScheme(String partyGroupTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("partyGroupTypeScheme"), String.class, getPartyGroupTypeScheme(), this);
		}
		

		PartyGroupType.PartyGroupTypeBuilder prune();
	}

	/*********************** Immutable Implementation of PartyGroupType  ***********************/
	class PartyGroupTypeImpl implements PartyGroupType {
		private final String value;
		private final String partyGroupTypeScheme;
		
		protected PartyGroupTypeImpl(PartyGroupType.PartyGroupTypeBuilder builder) {
			this.value = builder.getValue();
			this.partyGroupTypeScheme = builder.getPartyGroupTypeScheme();
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
		@RosettaAttribute("partyGroupTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyGroupTypeScheme")
		public String getPartyGroupTypeScheme() {
			return partyGroupTypeScheme;
		}
		
		@Override
		public PartyGroupType build() {
			return this;
		}
		
		@Override
		public PartyGroupType.PartyGroupTypeBuilder toBuilder() {
			PartyGroupType.PartyGroupTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyGroupType.PartyGroupTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPartyGroupTypeScheme()).ifPresent(builder::setPartyGroupTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyGroupType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyGroupTypeScheme, _that.getPartyGroupTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyGroupTypeScheme != null ? partyGroupTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyGroupType {" +
				"value=" + this.value + ", " +
				"partyGroupTypeScheme=" + this.partyGroupTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyGroupType  ***********************/
	class PartyGroupTypeBuilderImpl implements PartyGroupType.PartyGroupTypeBuilder {
	
		protected String value;
		protected String partyGroupTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyGroupTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyGroupTypeScheme")
		public String getPartyGroupTypeScheme() {
			return partyGroupTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public PartyGroupType.PartyGroupTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("partyGroupTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyGroupTypeScheme")
		@Override
		public PartyGroupType.PartyGroupTypeBuilder setPartyGroupTypeScheme(String _partyGroupTypeScheme) {
			this.partyGroupTypeScheme = _partyGroupTypeScheme == null ? null : _partyGroupTypeScheme;
			return this;
		}
		
		@Override
		public PartyGroupType build() {
			return new PartyGroupType.PartyGroupTypeImpl(this);
		}
		
		@Override
		public PartyGroupType.PartyGroupTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyGroupType.PartyGroupTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPartyGroupTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyGroupType.PartyGroupTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyGroupType.PartyGroupTypeBuilder o = (PartyGroupType.PartyGroupTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPartyGroupTypeScheme(), o.getPartyGroupTypeScheme(), this::setPartyGroupTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyGroupType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyGroupTypeScheme, _that.getPartyGroupTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyGroupTypeScheme != null ? partyGroupTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyGroupTypeBuilder {" +
				"value=" + this.value + ", " +
				"partyGroupTypeScheme=" + this.partyGroupTypeScheme +
			'}';
		}
	}
}
