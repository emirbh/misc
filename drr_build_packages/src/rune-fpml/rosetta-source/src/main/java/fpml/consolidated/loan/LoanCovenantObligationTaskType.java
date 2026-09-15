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
import fpml.consolidated.loan.meta.LoanCovenantObligationTaskTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a loan covenant obligation task type.
 *
 */
@RosettaDataType(value="LoanCovenantObligationTaskType", builder=LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationTaskType", model="fpml", builder=LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationTaskType extends RosettaModelObject {

	LoanCovenantObligationTaskTypeMeta metaData = new LoanCovenantObligationTaskTypeMeta();

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
	String getLegalCovenantTaskTypeScheme();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationTaskType build();
	
	LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder toBuilder();
	
	static LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder builder() {
		return new LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationTaskType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationTaskType> getType() {
		return LoanCovenantObligationTaskType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("legalCovenantTaskTypeScheme"), String.class, getLegalCovenantTaskTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationTaskTypeBuilder extends LoanCovenantObligationTaskType, RosettaModelObjectBuilder {
		LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder setValue(String value);
		LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder setLegalCovenantTaskTypeScheme(String legalCovenantTaskTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("legalCovenantTaskTypeScheme"), String.class, getLegalCovenantTaskTypeScheme(), this);
		}
		

		LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationTaskType  ***********************/
	class LoanCovenantObligationTaskTypeImpl implements LoanCovenantObligationTaskType {
		private final String value;
		private final String legalCovenantTaskTypeScheme;
		
		protected LoanCovenantObligationTaskTypeImpl(LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder builder) {
			this.value = builder.getValue();
			this.legalCovenantTaskTypeScheme = builder.getLegalCovenantTaskTypeScheme();
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
		@RosettaAttribute("legalCovenantTaskTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalCovenantTaskTypeScheme")
		public String getLegalCovenantTaskTypeScheme() {
			return legalCovenantTaskTypeScheme;
		}
		
		@Override
		public LoanCovenantObligationTaskType build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder toBuilder() {
			LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLegalCovenantTaskTypeScheme()).ifPresent(builder::setLegalCovenantTaskTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationTaskType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(legalCovenantTaskTypeScheme, _that.getLegalCovenantTaskTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (legalCovenantTaskTypeScheme != null ? legalCovenantTaskTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationTaskType {" +
				"value=" + this.value + ", " +
				"legalCovenantTaskTypeScheme=" + this.legalCovenantTaskTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationTaskType  ***********************/
	class LoanCovenantObligationTaskTypeBuilderImpl implements LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder {
	
		protected String value;
		protected String legalCovenantTaskTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("legalCovenantTaskTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalCovenantTaskTypeScheme")
		public String getLegalCovenantTaskTypeScheme() {
			return legalCovenantTaskTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("legalCovenantTaskTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalCovenantTaskTypeScheme")
		@Override
		public LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder setLegalCovenantTaskTypeScheme(String _legalCovenantTaskTypeScheme) {
			this.legalCovenantTaskTypeScheme = _legalCovenantTaskTypeScheme == null ? null : _legalCovenantTaskTypeScheme;
			return this;
		}
		
		@Override
		public LoanCovenantObligationTaskType build() {
			return new LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeImpl(this);
		}
		
		@Override
		public LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLegalCovenantTaskTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder o = (LoanCovenantObligationTaskType.LoanCovenantObligationTaskTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLegalCovenantTaskTypeScheme(), o.getLegalCovenantTaskTypeScheme(), this::setLegalCovenantTaskTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationTaskType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(legalCovenantTaskTypeScheme, _that.getLegalCovenantTaskTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (legalCovenantTaskTypeScheme != null ? legalCovenantTaskTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationTaskTypeBuilder {" +
				"value=" + this.value + ", " +
				"legalCovenantTaskTypeScheme=" + this.legalCovenantTaskTypeScheme +
			'}';
		}
	}
}
