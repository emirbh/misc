package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.fpmlenum.LoanTransferFeePaidByEnum;
import fpml.consolidated.loan.meta.TransferFeeDefinitionChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="TransferFeeDefinitionChoice", builder=TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TransferFeeDefinitionChoice", model="fpml", builder=TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilderImpl.class, version="2.1.1")
public interface TransferFeeDefinitionChoice extends RosettaModelObject {

	TransferFeeDefinitionChoiceMeta metaData = new TransferFeeDefinitionChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A rule which defines by whom (and how) the transfer fee is to be paid.
	 *
	 */
	LoanTransferFeePaidByEnum getPaymentRule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional free form text feel to describe the transfer fee payment rule, as necessary.
	 *
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	TransferFeeDefinitionChoice build();
	
	TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder toBuilder();
	
	static TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder builder() {
		return new TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransferFeeDefinitionChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TransferFeeDefinitionChoice> getType() {
		return TransferFeeDefinitionChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("paymentRule"), LoanTransferFeePaidByEnum.class, getPaymentRule(), this);
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransferFeeDefinitionChoiceBuilder extends TransferFeeDefinitionChoice, RosettaModelObjectBuilder {
		TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder setPaymentRule(LoanTransferFeePaidByEnum paymentRule);
		TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("paymentRule"), LoanTransferFeePaidByEnum.class, getPaymentRule(), this);
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of TransferFeeDefinitionChoice  ***********************/
	class TransferFeeDefinitionChoiceImpl implements TransferFeeDefinitionChoice {
		private final LoanTransferFeePaidByEnum paymentRule;
		private final String description;
		
		protected TransferFeeDefinitionChoiceImpl(TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder builder) {
			this.paymentRule = builder.getPaymentRule();
			this.description = builder.getDescription();
		}
		
		@Override
		@RosettaAttribute("paymentRule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentRule")
		public LoanTransferFeePaidByEnum getPaymentRule() {
			return paymentRule;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		public TransferFeeDefinitionChoice build() {
			return this;
		}
		
		@Override
		public TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder toBuilder() {
			TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder builder) {
			ofNullable(getPaymentRule()).ifPresent(builder::setPaymentRule);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferFeeDefinitionChoice _that = getType().cast(o);
		
			if (!Objects.equals(paymentRule, _that.getPaymentRule())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentRule != null ? paymentRule.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferFeeDefinitionChoice {" +
				"paymentRule=" + this.paymentRule + ", " +
				"description=" + this.description +
			'}';
		}
	}

	/*********************** Builder Implementation of TransferFeeDefinitionChoice  ***********************/
	class TransferFeeDefinitionChoiceBuilderImpl implements TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder {
	
		protected LoanTransferFeePaidByEnum paymentRule;
		protected String description;
		
		@Override
		@RosettaAttribute("paymentRule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentRule")
		public LoanTransferFeePaidByEnum getPaymentRule() {
			return paymentRule;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@RosettaAttribute("paymentRule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentRule")
		@Override
		public TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder setPaymentRule(LoanTransferFeePaidByEnum _paymentRule) {
			this.paymentRule = _paymentRule == null ? null : _paymentRule;
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public TransferFeeDefinitionChoice build() {
			return new TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceImpl(this);
		}
		
		@Override
		public TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaymentRule()!=null) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder o = (TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder) other;
			
			
			merger.mergeBasic(getPaymentRule(), o.getPaymentRule(), this::setPaymentRule);
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferFeeDefinitionChoice _that = getType().cast(o);
		
			if (!Objects.equals(paymentRule, _that.getPaymentRule())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentRule != null ? paymentRule.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferFeeDefinitionChoiceBuilder {" +
				"paymentRule=" + this.paymentRule + ", " +
				"description=" + this.description +
			'}';
		}
	}
}
