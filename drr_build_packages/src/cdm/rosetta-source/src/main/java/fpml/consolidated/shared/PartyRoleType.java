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
import fpml.consolidated.shared.meta.PartyRoleTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type refining the role a role played by a party in one or more transactions. Examples include "AllPositions" and "SomePositions" for Guarantor. This can be extended to provide custom types.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type refining the role a role played by a party in one or more transactions. Examples include "AllPositions" and "SomePositions" for Guarantor. This can be extended to provide custom types.
 *
 */
@RosettaDataType(value="PartyRoleType", builder=PartyRoleType.PartyRoleTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyRoleType", model="fpml", builder=PartyRoleType.PartyRoleTypeBuilderImpl.class, version="2.1.1")
public interface PartyRoleType extends RosettaModelObject {

	PartyRoleTypeMeta metaData = new PartyRoleTypeMeta();

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
	String getPartyRoleTypeScheme();

	/*********************** Build Methods  ***********************/
	PartyRoleType build();
	
	PartyRoleType.PartyRoleTypeBuilder toBuilder();
	
	static PartyRoleType.PartyRoleTypeBuilder builder() {
		return new PartyRoleType.PartyRoleTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyRoleType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyRoleType> getType() {
		return PartyRoleType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("partyRoleTypeScheme"), String.class, getPartyRoleTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyRoleTypeBuilder extends PartyRoleType, RosettaModelObjectBuilder {
		PartyRoleType.PartyRoleTypeBuilder setValue(String value);
		PartyRoleType.PartyRoleTypeBuilder setPartyRoleTypeScheme(String partyRoleTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("partyRoleTypeScheme"), String.class, getPartyRoleTypeScheme(), this);
		}
		

		PartyRoleType.PartyRoleTypeBuilder prune();
	}

	/*********************** Immutable Implementation of PartyRoleType  ***********************/
	class PartyRoleTypeImpl implements PartyRoleType {
		private final String value;
		private final String partyRoleTypeScheme;
		
		protected PartyRoleTypeImpl(PartyRoleType.PartyRoleTypeBuilder builder) {
			this.value = builder.getValue();
			this.partyRoleTypeScheme = builder.getPartyRoleTypeScheme();
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
		@RosettaAttribute("partyRoleTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyRoleTypeScheme")
		public String getPartyRoleTypeScheme() {
			return partyRoleTypeScheme;
		}
		
		@Override
		public PartyRoleType build() {
			return this;
		}
		
		@Override
		public PartyRoleType.PartyRoleTypeBuilder toBuilder() {
			PartyRoleType.PartyRoleTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyRoleType.PartyRoleTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPartyRoleTypeScheme()).ifPresent(builder::setPartyRoleTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyRoleType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyRoleTypeScheme, _that.getPartyRoleTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyRoleTypeScheme != null ? partyRoleTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyRoleType {" +
				"value=" + this.value + ", " +
				"partyRoleTypeScheme=" + this.partyRoleTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyRoleType  ***********************/
	class PartyRoleTypeBuilderImpl implements PartyRoleType.PartyRoleTypeBuilder {
	
		protected String value;
		protected String partyRoleTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyRoleTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyRoleTypeScheme")
		public String getPartyRoleTypeScheme() {
			return partyRoleTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public PartyRoleType.PartyRoleTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("partyRoleTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyRoleTypeScheme")
		@Override
		public PartyRoleType.PartyRoleTypeBuilder setPartyRoleTypeScheme(String _partyRoleTypeScheme) {
			this.partyRoleTypeScheme = _partyRoleTypeScheme == null ? null : _partyRoleTypeScheme;
			return this;
		}
		
		@Override
		public PartyRoleType build() {
			return new PartyRoleType.PartyRoleTypeImpl(this);
		}
		
		@Override
		public PartyRoleType.PartyRoleTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyRoleType.PartyRoleTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPartyRoleTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyRoleType.PartyRoleTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyRoleType.PartyRoleTypeBuilder o = (PartyRoleType.PartyRoleTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPartyRoleTypeScheme(), o.getPartyRoleTypeScheme(), this::setPartyRoleTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyRoleType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyRoleTypeScheme, _that.getPartyRoleTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyRoleTypeScheme != null ? partyRoleTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyRoleTypeBuilder {" +
				"value=" + this.value + ", " +
				"partyRoleTypeScheme=" + this.partyRoleTypeScheme +
			'}';
		}
	}
}
