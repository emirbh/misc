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
import fpml.consolidated.loan.meta.LegalActionIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A short form unique identifier for a loan legal action.
 *
 */
@RosettaDataType(value="LegalActionId", builder=LegalActionId.LegalActionIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LegalActionId", model="fpml", builder=LegalActionId.LegalActionIdBuilderImpl.class, version="2.1.1")
public interface LegalActionId extends RosettaModelObject {

	LegalActionIdMeta metaData = new LegalActionIdMeta();

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
	String getLegalActionIdScheme();
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
	LegalActionId build();
	
	LegalActionId.LegalActionIdBuilder toBuilder();
	
	static LegalActionId.LegalActionIdBuilder builder() {
		return new LegalActionId.LegalActionIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegalActionId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegalActionId> getType() {
		return LegalActionId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("legalActionIdScheme"), String.class, getLegalActionIdScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegalActionIdBuilder extends LegalActionId, RosettaModelObjectBuilder {
		LegalActionId.LegalActionIdBuilder setValue(String value);
		LegalActionId.LegalActionIdBuilder setLegalActionIdScheme(String legalActionIdScheme);
		LegalActionId.LegalActionIdBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("legalActionIdScheme"), String.class, getLegalActionIdScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		LegalActionId.LegalActionIdBuilder prune();
	}

	/*********************** Immutable Implementation of LegalActionId  ***********************/
	class LegalActionIdImpl implements LegalActionId {
		private final String value;
		private final String legalActionIdScheme;
		private final String id;
		
		protected LegalActionIdImpl(LegalActionId.LegalActionIdBuilder builder) {
			this.value = builder.getValue();
			this.legalActionIdScheme = builder.getLegalActionIdScheme();
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
		@RosettaAttribute("legalActionIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legalActionIdScheme")
		public String getLegalActionIdScheme() {
			return legalActionIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public LegalActionId build() {
			return this;
		}
		
		@Override
		public LegalActionId.LegalActionIdBuilder toBuilder() {
			LegalActionId.LegalActionIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalActionId.LegalActionIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLegalActionIdScheme()).ifPresent(builder::setLegalActionIdScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalActionId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(legalActionIdScheme, _that.getLegalActionIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (legalActionIdScheme != null ? legalActionIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalActionId {" +
				"value=" + this.value + ", " +
				"legalActionIdScheme=" + this.legalActionIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of LegalActionId  ***********************/
	class LegalActionIdBuilderImpl implements LegalActionId.LegalActionIdBuilder {
	
		protected String value;
		protected String legalActionIdScheme;
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
		@RosettaAttribute("legalActionIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legalActionIdScheme")
		public String getLegalActionIdScheme() {
			return legalActionIdScheme;
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
		public LegalActionId.LegalActionIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("legalActionIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legalActionIdScheme")
		@Override
		public LegalActionId.LegalActionIdBuilder setLegalActionIdScheme(String _legalActionIdScheme) {
			this.legalActionIdScheme = _legalActionIdScheme == null ? null : _legalActionIdScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LegalActionId.LegalActionIdBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public LegalActionId build() {
			return new LegalActionId.LegalActionIdImpl(this);
		}
		
		@Override
		public LegalActionId.LegalActionIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalActionId.LegalActionIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLegalActionIdScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalActionId.LegalActionIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegalActionId.LegalActionIdBuilder o = (LegalActionId.LegalActionIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLegalActionIdScheme(), o.getLegalActionIdScheme(), this::setLegalActionIdScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalActionId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(legalActionIdScheme, _that.getLegalActionIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (legalActionIdScheme != null ? legalActionIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalActionIdBuilder {" +
				"value=" + this.value + ", " +
				"legalActionIdScheme=" + this.legalActionIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
