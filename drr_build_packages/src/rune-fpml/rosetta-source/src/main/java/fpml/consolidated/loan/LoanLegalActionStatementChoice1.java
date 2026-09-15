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
import fpml.consolidated.loan.meta.LoanLegalActionStatementChoice1Meta;
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
@RosettaDataType(value="LoanLegalActionStatementChoice1", builder=LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1BuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionStatementChoice1", model="fpml", builder=LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1BuilderImpl.class, version="2.1.1")
public interface LoanLegalActionStatementChoice1 extends RosettaModelObject {

	LoanLegalActionStatementChoice1Meta metaData = new LoanLegalActionStatementChoice1Meta();

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
	LoanLegalActionStatementChoice1 build();
	
	LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder toBuilder();
	
	static LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder builder() {
		return new LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionStatementChoice1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionStatementChoice1> getType() {
		return LoanLegalActionStatementChoice1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("contractIdentifier"), processor, LoanContractIdentifier.class, getContractIdentifier());
		processRosetta(path.newSubPath("contractSummary"), processor, LoanContractSummary.class, getContractSummary());
		processRosetta(path.newSubPath("contract"), processor, LoanContract.class, getContract());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionStatementChoice1Builder extends LoanLegalActionStatementChoice1, RosettaModelObjectBuilder {
		LoanContractIdentifier.LoanContractIdentifierBuilder getOrCreateContractIdentifier();
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder getContractIdentifier();
		LoanContractSummary.LoanContractSummaryBuilder getOrCreateContractSummary();
		@Override
		LoanContractSummary.LoanContractSummaryBuilder getContractSummary();
		LoanContract.LoanContractBuilder getOrCreateContract();
		@Override
		LoanContract.LoanContractBuilder getContract();
		LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder setContractIdentifier(LoanContractIdentifier contractIdentifier);
		LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder setContractSummary(LoanContractSummary contractSummary);
		LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder setContract(LoanContract contract);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("contractIdentifier"), processor, LoanContractIdentifier.LoanContractIdentifierBuilder.class, getContractIdentifier());
			processRosetta(path.newSubPath("contractSummary"), processor, LoanContractSummary.LoanContractSummaryBuilder.class, getContractSummary());
			processRosetta(path.newSubPath("contract"), processor, LoanContract.LoanContractBuilder.class, getContract());
		}
		

		LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionStatementChoice1  ***********************/
	class LoanLegalActionStatementChoice1Impl implements LoanLegalActionStatementChoice1 {
		private final LoanContractIdentifier contractIdentifier;
		private final LoanContractSummary contractSummary;
		private final LoanContract contract;
		
		protected LoanLegalActionStatementChoice1Impl(LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder builder) {
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
		public LoanLegalActionStatementChoice1 build() {
			return this;
		}
		
		@Override
		public LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder toBuilder() {
			LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder builder) {
			ofNullable(getContractIdentifier()).ifPresent(builder::setContractIdentifier);
			ofNullable(getContractSummary()).ifPresent(builder::setContractSummary);
			ofNullable(getContract()).ifPresent(builder::setContract);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionStatementChoice1 _that = getType().cast(o);
		
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
			return "LoanLegalActionStatementChoice1 {" +
				"contractIdentifier=" + this.contractIdentifier + ", " +
				"contractSummary=" + this.contractSummary + ", " +
				"contract=" + this.contract +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalActionStatementChoice1  ***********************/
	class LoanLegalActionStatementChoice1BuilderImpl implements LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder {
	
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
		public LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder setContractIdentifier(LoanContractIdentifier _contractIdentifier) {
			this.contractIdentifier = _contractIdentifier == null ? null : _contractIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractSummary")
		@Override
		public LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder setContractSummary(LoanContractSummary _contractSummary) {
			this.contractSummary = _contractSummary == null ? null : _contractSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contract")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contract")
		@Override
		public LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder setContract(LoanContract _contract) {
			this.contract = _contract == null ? null : _contract.toBuilder();
			return this;
		}
		
		@Override
		public LoanLegalActionStatementChoice1 build() {
			return new LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Impl(this);
		}
		
		@Override
		public LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder prune() {
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
		public LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder o = (LoanLegalActionStatementChoice1.LoanLegalActionStatementChoice1Builder) other;
			
			merger.mergeRosetta(getContractIdentifier(), o.getContractIdentifier(), this::setContractIdentifier);
			merger.mergeRosetta(getContractSummary(), o.getContractSummary(), this::setContractSummary);
			merger.mergeRosetta(getContract(), o.getContract(), this::setContract);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionStatementChoice1 _that = getType().cast(o);
		
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
			return "LoanLegalActionStatementChoice1Builder {" +
				"contractIdentifier=" + this.contractIdentifier + ", " +
				"contractSummary=" + this.contractSummary + ", " +
				"contract=" + this.contract +
			'}';
		}
	}
}
