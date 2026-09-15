package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.loan.meta.LoanTradingCounterpartySettlementFundingFactorsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that defines the factors that impact settlement cashflows.
 *
 */
@RosettaDataType(value="LoanTradingCounterpartySettlementFundingFactors", builder=LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradingCounterpartySettlementFundingFactors", model="fpml", builder=LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilderImpl.class, version="2.1.1")
public interface LoanTradingCounterpartySettlementFundingFactors extends RosettaModelObject {

	LoanTradingCounterpartySettlementFundingFactorsMeta metaData = new LoanTradingCounterpartySettlementFundingFactorsMeta();

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
	LoanTradingDelayedCompensation getDelayedCompensation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LoanTradingCostOfCarry getCostOfCarry();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The total economic benefit, based on facility-level activity between trade and settlement date, payable to the buyer of the asset.
	 *
	 */
	List<? extends LoanTradingEconomicBenefit> getEconomicBenefit();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Counterparty shares of the transfer fee owed to the agent.
	 *
	 */
	BuyerSellerAmounts getTransferFeeAmounts();

	/*********************** Build Methods  ***********************/
	LoanTradingCounterpartySettlementFundingFactors build();
	
	LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder toBuilder();
	
	static LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder builder() {
		return new LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingCounterpartySettlementFundingFactors> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradingCounterpartySettlementFundingFactors> getType() {
		return LoanTradingCounterpartySettlementFundingFactors.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("delayedCompensation"), processor, LoanTradingDelayedCompensation.class, getDelayedCompensation());
		processRosetta(path.newSubPath("costOfCarry"), processor, LoanTradingCostOfCarry.class, getCostOfCarry());
		processRosetta(path.newSubPath("economicBenefit"), processor, LoanTradingEconomicBenefit.class, getEconomicBenefit());
		processRosetta(path.newSubPath("transferFeeAmounts"), processor, BuyerSellerAmounts.class, getTransferFeeAmounts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingCounterpartySettlementFundingFactorsBuilder extends LoanTradingCounterpartySettlementFundingFactors, RosettaModelObjectBuilder {
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder getOrCreateDelayedCompensation();
		@Override
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder getDelayedCompensation();
		LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder getOrCreateCostOfCarry();
		@Override
		LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder getCostOfCarry();
		LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder getOrCreateEconomicBenefit(int index);
		@Override
		List<? extends LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder> getEconomicBenefit();
		BuyerSellerAmounts.BuyerSellerAmountsBuilder getOrCreateTransferFeeAmounts();
		@Override
		BuyerSellerAmounts.BuyerSellerAmountsBuilder getTransferFeeAmounts();
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder setDelayedCompensation(LoanTradingDelayedCompensation delayedCompensation);
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder setCostOfCarry(LoanTradingCostOfCarry costOfCarry);
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder addEconomicBenefit(LoanTradingEconomicBenefit economicBenefit);
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder addEconomicBenefit(LoanTradingEconomicBenefit economicBenefit, int idx);
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder addEconomicBenefit(List<? extends LoanTradingEconomicBenefit> economicBenefit);
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder setEconomicBenefit(List<? extends LoanTradingEconomicBenefit> economicBenefit);
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder setTransferFeeAmounts(BuyerSellerAmounts transferFeeAmounts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("delayedCompensation"), processor, LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder.class, getDelayedCompensation());
			processRosetta(path.newSubPath("costOfCarry"), processor, LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder.class, getCostOfCarry());
			processRosetta(path.newSubPath("economicBenefit"), processor, LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder.class, getEconomicBenefit());
			processRosetta(path.newSubPath("transferFeeAmounts"), processor, BuyerSellerAmounts.BuyerSellerAmountsBuilder.class, getTransferFeeAmounts());
		}
		

		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingCounterpartySettlementFundingFactors  ***********************/
	class LoanTradingCounterpartySettlementFundingFactorsImpl implements LoanTradingCounterpartySettlementFundingFactors {
		private final LoanTradingDelayedCompensation delayedCompensation;
		private final LoanTradingCostOfCarry costOfCarry;
		private final List<? extends LoanTradingEconomicBenefit> economicBenefit;
		private final BuyerSellerAmounts transferFeeAmounts;
		
		protected LoanTradingCounterpartySettlementFundingFactorsImpl(LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder builder) {
			this.delayedCompensation = ofNullable(builder.getDelayedCompensation()).map(f->f.build()).orElse(null);
			this.costOfCarry = ofNullable(builder.getCostOfCarry()).map(f->f.build()).orElse(null);
			this.economicBenefit = ofNullable(builder.getEconomicBenefit()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.transferFeeAmounts = ofNullable(builder.getTransferFeeAmounts()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("delayedCompensation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delayedCompensation")
		public LoanTradingDelayedCompensation getDelayedCompensation() {
			return delayedCompensation;
		}
		
		@Override
		@RosettaAttribute("costOfCarry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("costOfCarry")
		public LoanTradingCostOfCarry getCostOfCarry() {
			return costOfCarry;
		}
		
		@Override
		@RosettaAttribute("economicBenefit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("economicBenefit")
		public List<? extends LoanTradingEconomicBenefit> getEconomicBenefit() {
			return economicBenefit;
		}
		
		@Override
		@RosettaAttribute("transferFeeAmounts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("transferFeeAmounts")
		public BuyerSellerAmounts getTransferFeeAmounts() {
			return transferFeeAmounts;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactors build() {
			return this;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder toBuilder() {
			LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder builder) {
			ofNullable(getDelayedCompensation()).ifPresent(builder::setDelayedCompensation);
			ofNullable(getCostOfCarry()).ifPresent(builder::setCostOfCarry);
			ofNullable(getEconomicBenefit()).ifPresent(builder::setEconomicBenefit);
			ofNullable(getTransferFeeAmounts()).ifPresent(builder::setTransferFeeAmounts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCounterpartySettlementFundingFactors _that = getType().cast(o);
		
			if (!Objects.equals(delayedCompensation, _that.getDelayedCompensation())) return false;
			if (!Objects.equals(costOfCarry, _that.getCostOfCarry())) return false;
			if (!ListEquals.listEquals(economicBenefit, _that.getEconomicBenefit())) return false;
			if (!Objects.equals(transferFeeAmounts, _that.getTransferFeeAmounts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (delayedCompensation != null ? delayedCompensation.hashCode() : 0);
			_result = 31 * _result + (costOfCarry != null ? costOfCarry.hashCode() : 0);
			_result = 31 * _result + (economicBenefit != null ? economicBenefit.hashCode() : 0);
			_result = 31 * _result + (transferFeeAmounts != null ? transferFeeAmounts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCounterpartySettlementFundingFactors {" +
				"delayedCompensation=" + this.delayedCompensation + ", " +
				"costOfCarry=" + this.costOfCarry + ", " +
				"economicBenefit=" + this.economicBenefit + ", " +
				"transferFeeAmounts=" + this.transferFeeAmounts +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingCounterpartySettlementFundingFactors  ***********************/
	class LoanTradingCounterpartySettlementFundingFactorsBuilderImpl implements LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder {
	
		protected LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder delayedCompensation;
		protected LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder costOfCarry;
		protected List<LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder> economicBenefit = new ArrayList<>();
		protected BuyerSellerAmounts.BuyerSellerAmountsBuilder transferFeeAmounts;
		
		@Override
		@RosettaAttribute("delayedCompensation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delayedCompensation")
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder getDelayedCompensation() {
			return delayedCompensation;
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder getOrCreateDelayedCompensation() {
			LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder result;
			if (delayedCompensation!=null) {
				result = delayedCompensation;
			}
			else {
				result = delayedCompensation = LoanTradingDelayedCompensation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("costOfCarry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("costOfCarry")
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder getCostOfCarry() {
			return costOfCarry;
		}
		
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder getOrCreateCostOfCarry() {
			LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder result;
			if (costOfCarry!=null) {
				result = costOfCarry;
			}
			else {
				result = costOfCarry = LoanTradingCostOfCarry.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("economicBenefit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("economicBenefit")
		public List<? extends LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder> getEconomicBenefit() {
			return economicBenefit;
		}
		
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder getOrCreateEconomicBenefit(int index) {
			if (economicBenefit==null) {
				this.economicBenefit = new ArrayList<>();
			}
			return getIndex(economicBenefit, index, () -> {
						LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder newEconomicBenefit = LoanTradingEconomicBenefit.builder();
						return newEconomicBenefit;
					});
		}
		
		@Override
		@RosettaAttribute("transferFeeAmounts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("transferFeeAmounts")
		public BuyerSellerAmounts.BuyerSellerAmountsBuilder getTransferFeeAmounts() {
			return transferFeeAmounts;
		}
		
		@Override
		public BuyerSellerAmounts.BuyerSellerAmountsBuilder getOrCreateTransferFeeAmounts() {
			BuyerSellerAmounts.BuyerSellerAmountsBuilder result;
			if (transferFeeAmounts!=null) {
				result = transferFeeAmounts;
			}
			else {
				result = transferFeeAmounts = BuyerSellerAmounts.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("delayedCompensation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delayedCompensation")
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder setDelayedCompensation(LoanTradingDelayedCompensation _delayedCompensation) {
			this.delayedCompensation = _delayedCompensation == null ? null : _delayedCompensation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("costOfCarry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("costOfCarry")
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder setCostOfCarry(LoanTradingCostOfCarry _costOfCarry) {
			this.costOfCarry = _costOfCarry == null ? null : _costOfCarry.toBuilder();
			return this;
		}
		
		@RosettaAttribute("economicBenefit")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("economicBenefit")
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder addEconomicBenefit(LoanTradingEconomicBenefit _economicBenefit) {
			if (_economicBenefit != null) {
				this.economicBenefit.add(_economicBenefit.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder addEconomicBenefit(LoanTradingEconomicBenefit _economicBenefit, int idx) {
			getIndex(this.economicBenefit, idx, () -> _economicBenefit.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder addEconomicBenefit(List<? extends LoanTradingEconomicBenefit> economicBenefits) {
			if (economicBenefits != null) {
				for (final LoanTradingEconomicBenefit toAdd : economicBenefits) {
					this.economicBenefit.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("economicBenefit")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("economicBenefit")
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder setEconomicBenefit(List<? extends LoanTradingEconomicBenefit> economicBenefits) {
			if (economicBenefits == null) {
				this.economicBenefit = new ArrayList<>();
			} else {
				this.economicBenefit = economicBenefits.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("transferFeeAmounts")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("transferFeeAmounts")
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder setTransferFeeAmounts(BuyerSellerAmounts _transferFeeAmounts) {
			this.transferFeeAmounts = _transferFeeAmounts == null ? null : _transferFeeAmounts.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactors build() {
			return new LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsImpl(this);
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder prune() {
			if (delayedCompensation!=null && !delayedCompensation.prune().hasData()) delayedCompensation = null;
			if (costOfCarry!=null && !costOfCarry.prune().hasData()) costOfCarry = null;
			economicBenefit = economicBenefit.stream().filter(b->b!=null).<LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (transferFeeAmounts!=null && !transferFeeAmounts.prune().hasData()) transferFeeAmounts = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDelayedCompensation()!=null && getDelayedCompensation().hasData()) return true;
			if (getCostOfCarry()!=null && getCostOfCarry().hasData()) return true;
			if (getEconomicBenefit()!=null && getEconomicBenefit().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTransferFeeAmounts()!=null && getTransferFeeAmounts().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder o = (LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder) other;
			
			merger.mergeRosetta(getDelayedCompensation(), o.getDelayedCompensation(), this::setDelayedCompensation);
			merger.mergeRosetta(getCostOfCarry(), o.getCostOfCarry(), this::setCostOfCarry);
			merger.mergeRosetta(getEconomicBenefit(), o.getEconomicBenefit(), this::getOrCreateEconomicBenefit);
			merger.mergeRosetta(getTransferFeeAmounts(), o.getTransferFeeAmounts(), this::setTransferFeeAmounts);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCounterpartySettlementFundingFactors _that = getType().cast(o);
		
			if (!Objects.equals(delayedCompensation, _that.getDelayedCompensation())) return false;
			if (!Objects.equals(costOfCarry, _that.getCostOfCarry())) return false;
			if (!ListEquals.listEquals(economicBenefit, _that.getEconomicBenefit())) return false;
			if (!Objects.equals(transferFeeAmounts, _that.getTransferFeeAmounts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (delayedCompensation != null ? delayedCompensation.hashCode() : 0);
			_result = 31 * _result + (costOfCarry != null ? costOfCarry.hashCode() : 0);
			_result = 31 * _result + (economicBenefit != null ? economicBenefit.hashCode() : 0);
			_result = 31 * _result + (transferFeeAmounts != null ? transferFeeAmounts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCounterpartySettlementFundingFactorsBuilder {" +
				"delayedCompensation=" + this.delayedCompensation + ", " +
				"costOfCarry=" + this.costOfCarry + ", " +
				"economicBenefit=" + this.economicBenefit + ", " +
				"transferFeeAmounts=" + this.transferFeeAmounts +
			'}';
		}
	}
}
