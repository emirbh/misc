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
import fpml.consolidated.loan.meta.LoanContractNotificationChoiceMeta;
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
@RosettaDataType(value="LoanContractNotificationChoice", builder=LoanContractNotificationChoice.LoanContractNotificationChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanContractNotificationChoice", model="fpml", builder=LoanContractNotificationChoice.LoanContractNotificationChoiceBuilderImpl.class, version="2.1.1")
public interface LoanContractNotificationChoice extends RosettaModelObject {

	LoanContractNotificationChoiceMeta metaData = new LoanContractNotificationChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A loan contract identifier structure.
	 *
	 */
	LoanContractIdentifier getContractIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A loan contract summary structure.
	 *
	 */
	LoanContractSummary getContractSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A full loan contract structure.
	 *
	 */
	LoanContract getContract();

	/*********************** Build Methods  ***********************/
	LoanContractNotificationChoice build();
	
	LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder toBuilder();
	
	static LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder builder() {
		return new LoanContractNotificationChoice.LoanContractNotificationChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractNotificationChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanContractNotificationChoice> getType() {
		return LoanContractNotificationChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("contractIdentifier"), processor, LoanContractIdentifier.class, getContractIdentifier());
		processRosetta(path.newSubPath("contractSummary"), processor, LoanContractSummary.class, getContractSummary());
		processRosetta(path.newSubPath("contract"), processor, LoanContract.class, getContract());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractNotificationChoiceBuilder extends LoanContractNotificationChoice, RosettaModelObjectBuilder {
		LoanContractIdentifier.LoanContractIdentifierBuilder getOrCreateContractIdentifier();
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder getContractIdentifier();
		LoanContractSummary.LoanContractSummaryBuilder getOrCreateContractSummary();
		@Override
		LoanContractSummary.LoanContractSummaryBuilder getContractSummary();
		LoanContract.LoanContractBuilder getOrCreateContract();
		@Override
		LoanContract.LoanContractBuilder getContract();
		LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder setContractIdentifier(LoanContractIdentifier contractIdentifier);
		LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder setContractSummary(LoanContractSummary contractSummary);
		LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder setContract(LoanContract contract);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("contractIdentifier"), processor, LoanContractIdentifier.LoanContractIdentifierBuilder.class, getContractIdentifier());
			processRosetta(path.newSubPath("contractSummary"), processor, LoanContractSummary.LoanContractSummaryBuilder.class, getContractSummary());
			processRosetta(path.newSubPath("contract"), processor, LoanContract.LoanContractBuilder.class, getContract());
		}
		

		LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractNotificationChoice  ***********************/
	class LoanContractNotificationChoiceImpl implements LoanContractNotificationChoice {
		private final LoanContractIdentifier contractIdentifier;
		private final LoanContractSummary contractSummary;
		private final LoanContract contract;
		
		protected LoanContractNotificationChoiceImpl(LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder builder) {
			this.contractIdentifier = ofNullable(builder.getContractIdentifier()).map(f->f.build()).orElse(null);
			this.contractSummary = ofNullable(builder.getContractSummary()).map(f->f.build()).orElse(null);
			this.contract = ofNullable(builder.getContract()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("contractIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractIdentifier")
		public LoanContractIdentifier getContractIdentifier() {
			return contractIdentifier;
		}
		
		@Override
		@RosettaAttribute("contractSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractSummary")
		public LoanContractSummary getContractSummary() {
			return contractSummary;
		}
		
		@Override
		@RosettaAttribute("contract")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contract")
		public LoanContract getContract() {
			return contract;
		}
		
		@Override
		public LoanContractNotificationChoice build() {
			return this;
		}
		
		@Override
		public LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder toBuilder() {
			LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder builder) {
			ofNullable(getContractIdentifier()).ifPresent(builder::setContractIdentifier);
			ofNullable(getContractSummary()).ifPresent(builder::setContractSummary);
			ofNullable(getContract()).ifPresent(builder::setContract);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanContractNotificationChoice _that = getType().cast(o);
		
			if (!Objects.equals(contractIdentifier, _that.getContractIdentifier())) return false;
			if (!Objects.equals(contractSummary, _that.getContractSummary())) return false;
			if (!Objects.equals(contract, _that.getContract())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractIdentifier != null ? contractIdentifier.hashCode() : 0);
			_result = 31 * _result + (contractSummary != null ? contractSummary.hashCode() : 0);
			_result = 31 * _result + (contract != null ? contract.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractNotificationChoice {" +
				"contractIdentifier=" + this.contractIdentifier + ", " +
				"contractSummary=" + this.contractSummary + ", " +
				"contract=" + this.contract +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanContractNotificationChoice  ***********************/
	class LoanContractNotificationChoiceBuilderImpl implements LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder {
	
		protected LoanContractIdentifier.LoanContractIdentifierBuilder contractIdentifier;
		protected LoanContractSummary.LoanContractSummaryBuilder contractSummary;
		protected LoanContract.LoanContractBuilder contract;
		
		@Override
		@RosettaAttribute("contractIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractIdentifier")
		public LoanContractIdentifier.LoanContractIdentifierBuilder getContractIdentifier() {
			return contractIdentifier;
		}
		
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder getOrCreateContractIdentifier() {
			LoanContractIdentifier.LoanContractIdentifierBuilder result;
			if (contractIdentifier!=null) {
				result = contractIdentifier;
			}
			else {
				result = contractIdentifier = LoanContractIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contractSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractSummary")
		public LoanContractSummary.LoanContractSummaryBuilder getContractSummary() {
			return contractSummary;
		}
		
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder getOrCreateContractSummary() {
			LoanContractSummary.LoanContractSummaryBuilder result;
			if (contractSummary!=null) {
				result = contractSummary;
			}
			else {
				result = contractSummary = LoanContractSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contract")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contract")
		public LoanContract.LoanContractBuilder getContract() {
			return contract;
		}
		
		@Override
		public LoanContract.LoanContractBuilder getOrCreateContract() {
			LoanContract.LoanContractBuilder result;
			if (contract!=null) {
				result = contract;
			}
			else {
				result = contract = LoanContract.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("contractIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractIdentifier")
		@Override
		public LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder setContractIdentifier(LoanContractIdentifier _contractIdentifier) {
			this.contractIdentifier = _contractIdentifier == null ? null : _contractIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractSummary")
		@Override
		public LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder setContractSummary(LoanContractSummary _contractSummary) {
			this.contractSummary = _contractSummary == null ? null : _contractSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contract")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contract")
		@Override
		public LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder setContract(LoanContract _contract) {
			this.contract = _contract == null ? null : _contract.toBuilder();
			return this;
		}
		
		@Override
		public LoanContractNotificationChoice build() {
			return new LoanContractNotificationChoice.LoanContractNotificationChoiceImpl(this);
		}
		
		@Override
		public LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder prune() {
			if (contractIdentifier!=null && !contractIdentifier.prune().hasData()) contractIdentifier = null;
			if (contractSummary!=null && !contractSummary.prune().hasData()) contractSummary = null;
			if (contract!=null && !contract.prune().hasData()) contract = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContractIdentifier()!=null && getContractIdentifier().hasData()) return true;
			if (getContractSummary()!=null && getContractSummary().hasData()) return true;
			if (getContract()!=null && getContract().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder o = (LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder) other;
			
			merger.mergeRosetta(getContractIdentifier(), o.getContractIdentifier(), this::setContractIdentifier);
			merger.mergeRosetta(getContractSummary(), o.getContractSummary(), this::setContractSummary);
			merger.mergeRosetta(getContract(), o.getContract(), this::setContract);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanContractNotificationChoice _that = getType().cast(o);
		
			if (!Objects.equals(contractIdentifier, _that.getContractIdentifier())) return false;
			if (!Objects.equals(contractSummary, _that.getContractSummary())) return false;
			if (!Objects.equals(contract, _that.getContract())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractIdentifier != null ? contractIdentifier.hashCode() : 0);
			_result = 31 * _result + (contractSummary != null ? contractSummary.hashCode() : 0);
			_result = 31 * _result + (contract != null ? contract.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractNotificationChoiceBuilder {" +
				"contractIdentifier=" + this.contractIdentifier + ", " +
				"contractSummary=" + this.contractSummary + ", " +
				"contract=" + this.contract +
			'}';
		}
	}
}
