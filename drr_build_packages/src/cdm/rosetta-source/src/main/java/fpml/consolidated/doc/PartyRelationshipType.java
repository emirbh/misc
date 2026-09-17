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
import fpml.consolidated.doc.meta.PartyRelationshipTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type containing a code representing how two parties are related, e.g. Affiliated, Intragroup, None.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type containing a code representing how two parties are related, e.g. Affiliated, Intragroup, None.
 *
 */
@RosettaDataType(value="PartyRelationshipType", builder=PartyRelationshipType.PartyRelationshipTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyRelationshipType", model="fpml", builder=PartyRelationshipType.PartyRelationshipTypeBuilderImpl.class, version="2.1.1")
public interface PartyRelationshipType extends RosettaModelObject {

	PartyRelationshipTypeMeta metaData = new PartyRelationshipTypeMeta();

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
	String getPartyRelationshipTypeScheme();
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
	PartyRelationshipType build();
	
	PartyRelationshipType.PartyRelationshipTypeBuilder toBuilder();
	
	static PartyRelationshipType.PartyRelationshipTypeBuilder builder() {
		return new PartyRelationshipType.PartyRelationshipTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyRelationshipType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyRelationshipType> getType() {
		return PartyRelationshipType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("partyRelationshipTypeScheme"), String.class, getPartyRelationshipTypeScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyRelationshipTypeBuilder extends PartyRelationshipType, RosettaModelObjectBuilder {
		PartyRelationshipType.PartyRelationshipTypeBuilder setValue(String value);
		PartyRelationshipType.PartyRelationshipTypeBuilder setPartyRelationshipTypeScheme(String partyRelationshipTypeScheme);
		PartyRelationshipType.PartyRelationshipTypeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("partyRelationshipTypeScheme"), String.class, getPartyRelationshipTypeScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PartyRelationshipType.PartyRelationshipTypeBuilder prune();
	}

	/*********************** Immutable Implementation of PartyRelationshipType  ***********************/
	class PartyRelationshipTypeImpl implements PartyRelationshipType {
		private final String value;
		private final String partyRelationshipTypeScheme;
		private final String id;
		
		protected PartyRelationshipTypeImpl(PartyRelationshipType.PartyRelationshipTypeBuilder builder) {
			this.value = builder.getValue();
			this.partyRelationshipTypeScheme = builder.getPartyRelationshipTypeScheme();
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
		@RosettaAttribute("partyRelationshipTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyRelationshipTypeScheme")
		public String getPartyRelationshipTypeScheme() {
			return partyRelationshipTypeScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public PartyRelationshipType build() {
			return this;
		}
		
		@Override
		public PartyRelationshipType.PartyRelationshipTypeBuilder toBuilder() {
			PartyRelationshipType.PartyRelationshipTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyRelationshipType.PartyRelationshipTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPartyRelationshipTypeScheme()).ifPresent(builder::setPartyRelationshipTypeScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyRelationshipType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyRelationshipTypeScheme, _that.getPartyRelationshipTypeScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyRelationshipTypeScheme != null ? partyRelationshipTypeScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyRelationshipType {" +
				"value=" + this.value + ", " +
				"partyRelationshipTypeScheme=" + this.partyRelationshipTypeScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyRelationshipType  ***********************/
	class PartyRelationshipTypeBuilderImpl implements PartyRelationshipType.PartyRelationshipTypeBuilder {
	
		protected String value;
		protected String partyRelationshipTypeScheme;
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
		@RosettaAttribute("partyRelationshipTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyRelationshipTypeScheme")
		public String getPartyRelationshipTypeScheme() {
			return partyRelationshipTypeScheme;
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
		public PartyRelationshipType.PartyRelationshipTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("partyRelationshipTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyRelationshipTypeScheme")
		@Override
		public PartyRelationshipType.PartyRelationshipTypeBuilder setPartyRelationshipTypeScheme(String _partyRelationshipTypeScheme) {
			this.partyRelationshipTypeScheme = _partyRelationshipTypeScheme == null ? null : _partyRelationshipTypeScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PartyRelationshipType.PartyRelationshipTypeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public PartyRelationshipType build() {
			return new PartyRelationshipType.PartyRelationshipTypeImpl(this);
		}
		
		@Override
		public PartyRelationshipType.PartyRelationshipTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyRelationshipType.PartyRelationshipTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPartyRelationshipTypeScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyRelationshipType.PartyRelationshipTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyRelationshipType.PartyRelationshipTypeBuilder o = (PartyRelationshipType.PartyRelationshipTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPartyRelationshipTypeScheme(), o.getPartyRelationshipTypeScheme(), this::setPartyRelationshipTypeScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyRelationshipType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyRelationshipTypeScheme, _that.getPartyRelationshipTypeScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyRelationshipTypeScheme != null ? partyRelationshipTypeScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyRelationshipTypeBuilder {" +
				"value=" + this.value + ", " +
				"partyRelationshipTypeScheme=" + this.partyRelationshipTypeScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
