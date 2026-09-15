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
import fpml.consolidated.loan.meta.LoanLegalActionStatusTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to identify a loan legal action status type, based on a scheme.
 *
 */
@RosettaDataType(value="LoanLegalActionStatusType", builder=LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionStatusType", model="fpml", builder=LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilderImpl.class, version="2.1.1")
public interface LoanLegalActionStatusType extends RosettaModelObject {

	LoanLegalActionStatusTypeMeta metaData = new LoanLegalActionStatusTypeMeta();

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
	String getLoanLegalActionStatusTypeScheme();

	/*********************** Build Methods  ***********************/
	LoanLegalActionStatusType build();
	
	LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder toBuilder();
	
	static LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder builder() {
		return new LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionStatusType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionStatusType> getType() {
		return LoanLegalActionStatusType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("loanLegalActionStatusTypeScheme"), String.class, getLoanLegalActionStatusTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionStatusTypeBuilder extends LoanLegalActionStatusType, RosettaModelObjectBuilder {
		LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder setValue(String value);
		LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder setLoanLegalActionStatusTypeScheme(String loanLegalActionStatusTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("loanLegalActionStatusTypeScheme"), String.class, getLoanLegalActionStatusTypeScheme(), this);
		}
		

		LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionStatusType  ***********************/
	class LoanLegalActionStatusTypeImpl implements LoanLegalActionStatusType {
		private final String value;
		private final String loanLegalActionStatusTypeScheme;
		
		protected LoanLegalActionStatusTypeImpl(LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder builder) {
			this.value = builder.getValue();
			this.loanLegalActionStatusTypeScheme = builder.getLoanLegalActionStatusTypeScheme();
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
		@RosettaAttribute("loanLegalActionStatusTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanLegalActionStatusTypeScheme")
		public String getLoanLegalActionStatusTypeScheme() {
			return loanLegalActionStatusTypeScheme;
		}
		
		@Override
		public LoanLegalActionStatusType build() {
			return this;
		}
		
		@Override
		public LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder toBuilder() {
			LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLoanLegalActionStatusTypeScheme()).ifPresent(builder::setLoanLegalActionStatusTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionStatusType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanLegalActionStatusTypeScheme, _that.getLoanLegalActionStatusTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionStatusTypeScheme != null ? loanLegalActionStatusTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionStatusType {" +
				"value=" + this.value + ", " +
				"loanLegalActionStatusTypeScheme=" + this.loanLegalActionStatusTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalActionStatusType  ***********************/
	class LoanLegalActionStatusTypeBuilderImpl implements LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder {
	
		protected String value;
		protected String loanLegalActionStatusTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("loanLegalActionStatusTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanLegalActionStatusTypeScheme")
		public String getLoanLegalActionStatusTypeScheme() {
			return loanLegalActionStatusTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("loanLegalActionStatusTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loanLegalActionStatusTypeScheme")
		@Override
		public LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder setLoanLegalActionStatusTypeScheme(String _loanLegalActionStatusTypeScheme) {
			this.loanLegalActionStatusTypeScheme = _loanLegalActionStatusTypeScheme == null ? null : _loanLegalActionStatusTypeScheme;
			return this;
		}
		
		@Override
		public LoanLegalActionStatusType build() {
			return new LoanLegalActionStatusType.LoanLegalActionStatusTypeImpl(this);
		}
		
		@Override
		public LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLoanLegalActionStatusTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder o = (LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLoanLegalActionStatusTypeScheme(), o.getLoanLegalActionStatusTypeScheme(), this::setLoanLegalActionStatusTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionStatusType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanLegalActionStatusTypeScheme, _that.getLoanLegalActionStatusTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionStatusTypeScheme != null ? loanLegalActionStatusTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionStatusTypeBuilder {" +
				"value=" + this.value + ", " +
				"loanLegalActionStatusTypeScheme=" + this.loanLegalActionStatusTypeScheme +
			'}';
		}
	}
}
