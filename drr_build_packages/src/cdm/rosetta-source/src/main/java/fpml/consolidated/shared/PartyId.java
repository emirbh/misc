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
import fpml.consolidated.shared.meta.PartyIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for party identifiers.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for party identifiers.
 *
 */
@RosettaDataType(value="PartyId", builder=PartyId.PartyIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyId", model="fpml", builder=PartyId.PartyIdBuilderImpl.class, version="2.1.1")
public interface PartyId extends RosettaModelObject {

	PartyIdMeta metaData = new PartyIdMeta();

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
	String getPartyIdScheme();

	/*********************** Build Methods  ***********************/
	PartyId build();
	
	PartyId.PartyIdBuilder toBuilder();
	
	static PartyId.PartyIdBuilder builder() {
		return new PartyId.PartyIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyId> getType() {
		return PartyId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("partyIdScheme"), String.class, getPartyIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyIdBuilder extends PartyId, RosettaModelObjectBuilder {
		PartyId.PartyIdBuilder setValue(String value);
		PartyId.PartyIdBuilder setPartyIdScheme(String partyIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("partyIdScheme"), String.class, getPartyIdScheme(), this);
		}
		

		PartyId.PartyIdBuilder prune();
	}

	/*********************** Immutable Implementation of PartyId  ***********************/
	class PartyIdImpl implements PartyId {
		private final String value;
		private final String partyIdScheme;
		
		protected PartyIdImpl(PartyId.PartyIdBuilder builder) {
			this.value = builder.getValue();
			this.partyIdScheme = builder.getPartyIdScheme();
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
		@RosettaAttribute("partyIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyIdScheme")
		public String getPartyIdScheme() {
			return partyIdScheme;
		}
		
		@Override
		public PartyId build() {
			return this;
		}
		
		@Override
		public PartyId.PartyIdBuilder toBuilder() {
			PartyId.PartyIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyId.PartyIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPartyIdScheme()).ifPresent(builder::setPartyIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyIdScheme, _that.getPartyIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyIdScheme != null ? partyIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyId {" +
				"value=" + this.value + ", " +
				"partyIdScheme=" + this.partyIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyId  ***********************/
	class PartyIdBuilderImpl implements PartyId.PartyIdBuilder {
	
		protected String value;
		protected String partyIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyIdScheme")
		public String getPartyIdScheme() {
			return partyIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public PartyId.PartyIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("partyIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyIdScheme")
		@Override
		public PartyId.PartyIdBuilder setPartyIdScheme(String _partyIdScheme) {
			this.partyIdScheme = _partyIdScheme == null ? null : _partyIdScheme;
			return this;
		}
		
		@Override
		public PartyId build() {
			return new PartyId.PartyIdImpl(this);
		}
		
		@Override
		public PartyId.PartyIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyId.PartyIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPartyIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyId.PartyIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyId.PartyIdBuilder o = (PartyId.PartyIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPartyIdScheme(), o.getPartyIdScheme(), this::setPartyIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyIdScheme, _that.getPartyIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyIdScheme != null ? partyIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyIdBuilder {" +
				"value=" + this.value + ", " +
				"partyIdScheme=" + this.partyIdScheme +
			'}';
		}
	}
}
