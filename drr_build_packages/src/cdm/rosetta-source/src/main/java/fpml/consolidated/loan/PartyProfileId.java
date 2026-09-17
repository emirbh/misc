package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.PartyProfileIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that defines a party profile identifier based on a qualifying scheme.
 *
 */
@RosettaDataType(value="PartyProfileId", builder=PartyProfileId.PartyProfileIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyProfileId", model="fpml", builder=PartyProfileId.PartyProfileIdBuilderImpl.class, version="2.1.1")
public interface PartyProfileId extends RosettaModelObject {

	PartyProfileIdMeta metaData = new PartyProfileIdMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getPartyProfileIdScheme();
	/**
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
	PartyProfileId build();
	
	PartyProfileId.PartyProfileIdBuilder toBuilder();
	
	static PartyProfileId.PartyProfileIdBuilder builder() {
		return new PartyProfileId.PartyProfileIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyProfileId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyProfileId> getType() {
		return PartyProfileId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("partyProfileIdScheme"), String.class, getPartyProfileIdScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyProfileIdBuilder extends PartyProfileId, RosettaModelObjectBuilder {
		PartyProfileId.PartyProfileIdBuilder setValue(String value);
		PartyProfileId.PartyProfileIdBuilder setPartyProfileIdScheme(String partyProfileIdScheme);
		PartyProfileId.PartyProfileIdBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("partyProfileIdScheme"), String.class, getPartyProfileIdScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PartyProfileId.PartyProfileIdBuilder prune();
	}

	/*********************** Immutable Implementation of PartyProfileId  ***********************/
	class PartyProfileIdImpl implements PartyProfileId {
		private final String value;
		private final String partyProfileIdScheme;
		private final String id;
		
		protected PartyProfileIdImpl(PartyProfileId.PartyProfileIdBuilder builder) {
			this.value = builder.getValue();
			this.partyProfileIdScheme = builder.getPartyProfileIdScheme();
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
		@RosettaAttribute("partyProfileIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyProfileIdScheme")
		public String getPartyProfileIdScheme() {
			return partyProfileIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public PartyProfileId build() {
			return this;
		}
		
		@Override
		public PartyProfileId.PartyProfileIdBuilder toBuilder() {
			PartyProfileId.PartyProfileIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyProfileId.PartyProfileIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPartyProfileIdScheme()).ifPresent(builder::setPartyProfileIdScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyProfileId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyProfileIdScheme, _that.getPartyProfileIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyProfileIdScheme != null ? partyProfileIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileId {" +
				"value=" + this.value + ", " +
				"partyProfileIdScheme=" + this.partyProfileIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyProfileId  ***********************/
	class PartyProfileIdBuilderImpl implements PartyProfileId.PartyProfileIdBuilder {
	
		protected String value;
		protected String partyProfileIdScheme;
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
		@RosettaAttribute("partyProfileIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyProfileIdScheme")
		public String getPartyProfileIdScheme() {
			return partyProfileIdScheme;
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
		public PartyProfileId.PartyProfileIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("partyProfileIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyProfileIdScheme")
		@Override
		public PartyProfileId.PartyProfileIdBuilder setPartyProfileIdScheme(String _partyProfileIdScheme) {
			this.partyProfileIdScheme = _partyProfileIdScheme == null ? null : _partyProfileIdScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PartyProfileId.PartyProfileIdBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public PartyProfileId build() {
			return new PartyProfileId.PartyProfileIdImpl(this);
		}
		
		@Override
		public PartyProfileId.PartyProfileIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfileId.PartyProfileIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPartyProfileIdScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfileId.PartyProfileIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyProfileId.PartyProfileIdBuilder o = (PartyProfileId.PartyProfileIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPartyProfileIdScheme(), o.getPartyProfileIdScheme(), this::setPartyProfileIdScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyProfileId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyProfileIdScheme, _that.getPartyProfileIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyProfileIdScheme != null ? partyProfileIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileIdBuilder {" +
				"value=" + this.value + ", " +
				"partyProfileIdScheme=" + this.partyProfileIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
