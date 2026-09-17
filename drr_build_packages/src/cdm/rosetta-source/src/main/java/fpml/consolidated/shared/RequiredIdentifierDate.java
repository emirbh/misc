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
import fpml.consolidated.shared.meta.RequiredIdentifierDateMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A date with a required identifier which can be referenced elsewhere.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A date with a required identifier which can be referenced elsewhere.
 *
 */
@RosettaDataType(value="RequiredIdentifierDate", builder=RequiredIdentifierDate.RequiredIdentifierDateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequiredIdentifierDate", model="fpml", builder=RequiredIdentifierDate.RequiredIdentifierDateBuilderImpl.class, version="2.1.1")
public interface RequiredIdentifierDate extends RosettaModelObject {

	RequiredIdentifierDateMeta metaData = new RequiredIdentifierDateMeta();

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
	ZonedDateTime getValue();
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
	RequiredIdentifierDate build();
	
	RequiredIdentifierDate.RequiredIdentifierDateBuilder toBuilder();
	
	static RequiredIdentifierDate.RequiredIdentifierDateBuilder builder() {
		return new RequiredIdentifierDate.RequiredIdentifierDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequiredIdentifierDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequiredIdentifierDate> getType() {
		return RequiredIdentifierDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), ZonedDateTime.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequiredIdentifierDateBuilder extends RequiredIdentifierDate, RosettaModelObjectBuilder {
		RequiredIdentifierDate.RequiredIdentifierDateBuilder setValue(ZonedDateTime value);
		RequiredIdentifierDate.RequiredIdentifierDateBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), ZonedDateTime.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		RequiredIdentifierDate.RequiredIdentifierDateBuilder prune();
	}

	/*********************** Immutable Implementation of RequiredIdentifierDate  ***********************/
	class RequiredIdentifierDateImpl implements RequiredIdentifierDate {
		private final ZonedDateTime value;
		private final String id;
		
		protected RequiredIdentifierDateImpl(RequiredIdentifierDate.RequiredIdentifierDateBuilder builder) {
			this.value = builder.getValue();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public ZonedDateTime getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public RequiredIdentifierDate build() {
			return this;
		}
		
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder toBuilder() {
			RequiredIdentifierDate.RequiredIdentifierDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequiredIdentifierDate.RequiredIdentifierDateBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RequiredIdentifierDate _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequiredIdentifierDate {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of RequiredIdentifierDate  ***********************/
	class RequiredIdentifierDateBuilderImpl implements RequiredIdentifierDate.RequiredIdentifierDateBuilder {
	
		protected ZonedDateTime value;
		protected String id;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public ZonedDateTime getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder setValue(ZonedDateTime _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public RequiredIdentifierDate build() {
			return new RequiredIdentifierDate.RequiredIdentifierDateImpl(this);
		}
		
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RequiredIdentifierDate.RequiredIdentifierDateBuilder o = (RequiredIdentifierDate.RequiredIdentifierDateBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RequiredIdentifierDate _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequiredIdentifierDateBuilder {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
