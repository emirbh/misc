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
import fpml.consolidated.loan.meta.LoanCovenantObligationCategoryTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a loan covenant obligation category type (e.g. affirmative, negative, or financial) based on a scheme.
 *
 */
@RosettaDataType(value="LoanCovenantObligationCategoryType", builder=LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationCategoryType", model="fpml", builder=LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationCategoryType extends RosettaModelObject {

	LoanCovenantObligationCategoryTypeMeta metaData = new LoanCovenantObligationCategoryTypeMeta();

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
	String getLoanCovenantObligationCategoryTypeScheme();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationCategoryType build();
	
	LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder toBuilder();
	
	static LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder builder() {
		return new LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationCategoryType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationCategoryType> getType() {
		return LoanCovenantObligationCategoryType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("loanCovenantObligationCategoryTypeScheme"), String.class, getLoanCovenantObligationCategoryTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationCategoryTypeBuilder extends LoanCovenantObligationCategoryType, RosettaModelObjectBuilder {
		LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder setValue(String value);
		LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder setLoanCovenantObligationCategoryTypeScheme(String loanCovenantObligationCategoryTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("loanCovenantObligationCategoryTypeScheme"), String.class, getLoanCovenantObligationCategoryTypeScheme(), this);
		}
		

		LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationCategoryType  ***********************/
	class LoanCovenantObligationCategoryTypeImpl implements LoanCovenantObligationCategoryType {
		private final String value;
		private final String loanCovenantObligationCategoryTypeScheme;
		
		protected LoanCovenantObligationCategoryTypeImpl(LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder builder) {
			this.value = builder.getValue();
			this.loanCovenantObligationCategoryTypeScheme = builder.getLoanCovenantObligationCategoryTypeScheme();
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
		@RosettaAttribute("loanCovenantObligationCategoryTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanCovenantObligationCategoryTypeScheme")
		public String getLoanCovenantObligationCategoryTypeScheme() {
			return loanCovenantObligationCategoryTypeScheme;
		}
		
		@Override
		public LoanCovenantObligationCategoryType build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder toBuilder() {
			LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLoanCovenantObligationCategoryTypeScheme()).ifPresent(builder::setLoanCovenantObligationCategoryTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationCategoryType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanCovenantObligationCategoryTypeScheme, _that.getLoanCovenantObligationCategoryTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationCategoryTypeScheme != null ? loanCovenantObligationCategoryTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationCategoryType {" +
				"value=" + this.value + ", " +
				"loanCovenantObligationCategoryTypeScheme=" + this.loanCovenantObligationCategoryTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationCategoryType  ***********************/
	class LoanCovenantObligationCategoryTypeBuilderImpl implements LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder {
	
		protected String value;
		protected String loanCovenantObligationCategoryTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationCategoryTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanCovenantObligationCategoryTypeScheme")
		public String getLoanCovenantObligationCategoryTypeScheme() {
			return loanCovenantObligationCategoryTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationCategoryTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loanCovenantObligationCategoryTypeScheme")
		@Override
		public LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder setLoanCovenantObligationCategoryTypeScheme(String _loanCovenantObligationCategoryTypeScheme) {
			this.loanCovenantObligationCategoryTypeScheme = _loanCovenantObligationCategoryTypeScheme == null ? null : _loanCovenantObligationCategoryTypeScheme;
			return this;
		}
		
		@Override
		public LoanCovenantObligationCategoryType build() {
			return new LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeImpl(this);
		}
		
		@Override
		public LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLoanCovenantObligationCategoryTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder o = (LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLoanCovenantObligationCategoryTypeScheme(), o.getLoanCovenantObligationCategoryTypeScheme(), this::setLoanCovenantObligationCategoryTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationCategoryType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanCovenantObligationCategoryTypeScheme, _that.getLoanCovenantObligationCategoryTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationCategoryTypeScheme != null ? loanCovenantObligationCategoryTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationCategoryTypeBuilder {" +
				"value=" + this.value + ", " +
				"loanCovenantObligationCategoryTypeScheme=" + this.loanCovenantObligationCategoryTypeScheme +
			'}';
		}
	}
}
