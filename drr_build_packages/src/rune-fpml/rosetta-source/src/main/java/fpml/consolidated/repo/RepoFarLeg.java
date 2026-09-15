package fpml.consolidated.repo;

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
import fpml.consolidated.repo.meta.RepoFarLegMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxRate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
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
 * version "recordkeeping-5.13"
 *
 * Provision A transaction leg for a repo is equivalent to a single cash transaction. It is augmented here to carry some values that are of interest for the repo. Also, note that the BuyerSeller model in this transaction must be the exact opposite of the one found in the near leg.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A transaction leg for a repo is equivalent to a single cash transaction. It is augmented here to carry some values that are of interest for the repo. Also, note that the BuyerSeller model in this transaction must be the exact opposite of the one found in the near leg.
 *
 */
@RosettaDataType(value="RepoFarLeg", builder=RepoFarLeg.RepoFarLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RepoFarLeg", model="fpml", builder=RepoFarLeg.RepoFarLegBuilderImpl.class, version="2.1.1")
public interface RepoFarLeg extends RepoLegBase {

	RepoFarLegMeta metaData = new RepoFarLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Settlement Amount
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settlement Amount
	 *
	 */
	Money getSettlementAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Settlement Currency for use where the Settlement Amount cannot be known in advance
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settlement Currency for use where the Settlement Amount cannot be known in advance
	 *
	 */
	Currency getSettlementCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the rate of a currency conversion that is used to compute settlement amount for cross-currency transactions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the rate of a currency conversion that is used to compute settlement amount for cross-currency transactions.
	 *
	 */
	FxRate getFxRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a delivery method for the security transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies a delivery method for the security transaction.
	 *
	 */
	DeliveryMethod getDeliveryMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Delivery Date for the transaction. Delivery Date can be populated when it is not equal to the Settlement Date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Delivery Date for the transaction. Delivery Date can be populated when it is not equal to the Settlement Date.
	 *
	 */
	AdjustableOrRelativeDate getDeliveryDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Collateral element is used to carry the quantity and price details that are required to ensure that a repo contract is executed at fair value, with the value of the collateral matching the cash amount of the repo. Collateral is declared as optional here, with multiple cardinalities, since there can be a repo "Multi", with multiple instruments specified, or a "Cash Borrow/Loan" and “TriPartyRepo” with no collateral. In general cases, however it should be specified. This element can be omitted in farLeg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Collateral element is used to carry the quantity and price details that are required to ensure that a repo contract is executed at fair value, with the value of the collateral matching the cash amount of the repo. Collateral is declared as optional here, with multiple cardinalities, since there can be a repo "Multi", with multiple instruments specified, or a "Cash Borrow/Loan" and “TriPartyRepo” with no collateral. In general cases, however it should be specified. This element can be omitted in farLeg.
	 *
	 */
	List<? extends CollateralValuation> getCollateral();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The repo interest is basically the difference between the settlement amounts at spot and forward date. It is a fully figured amount, but it does not have to be specified in the message. It is not a 'Money' amount as it is implicitly expressed in the settlement currency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The repo interest is basically the difference between the settlement amounts at spot and forward date. It is a fully figured amount, but it does not have to be specified in the message. It is not a 'Money' amount as it is implicitly expressed in the settlement currency.
	 *
	 */
	BigDecimal getRepoInterest();

	/*********************** Build Methods  ***********************/
	RepoFarLeg build();
	
	RepoFarLeg.RepoFarLegBuilder toBuilder();
	
	static RepoFarLeg.RepoFarLegBuilder builder() {
		return new RepoFarLeg.RepoFarLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RepoFarLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RepoFarLeg> getType() {
		return RepoFarLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.class, getBuyerAccountReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.class, getSellerAccountReference());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementAmount"), processor, Money.class, getSettlementAmount());
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("fxRate"), processor, FxRate.class, getFxRate());
		processRosetta(path.newSubPath("deliveryMethod"), processor, DeliveryMethod.class, getDeliveryMethod());
		processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableOrRelativeDate.class, getDeliveryDate());
		processRosetta(path.newSubPath("collateral"), processor, CollateralValuation.class, getCollateral());
		processor.processBasic(path.newSubPath("repoInterest"), BigDecimal.class, getRepoInterest(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepoFarLegBuilder extends RepoFarLeg, RepoLegBase.RepoLegBaseBuilder {
		Money.MoneyBuilder getOrCreateSettlementAmount();
		@Override
		Money.MoneyBuilder getSettlementAmount();
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		@Override
		Currency.CurrencyBuilder getSettlementCurrency();
		FxRate.FxRateBuilder getOrCreateFxRate();
		@Override
		FxRate.FxRateBuilder getFxRate();
		DeliveryMethod.DeliveryMethodBuilder getOrCreateDeliveryMethod();
		@Override
		DeliveryMethod.DeliveryMethodBuilder getDeliveryMethod();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateDeliveryDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getDeliveryDate();
		CollateralValuation.CollateralValuationBuilder getOrCreateCollateral(int index);
		@Override
		List<? extends CollateralValuation.CollateralValuationBuilder> getCollateral();
		@Override
		RepoFarLeg.RepoFarLegBuilder setId(String id);
		@Override
		RepoFarLeg.RepoFarLegBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		RepoFarLeg.RepoFarLegBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		RepoFarLeg.RepoFarLegBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		RepoFarLeg.RepoFarLegBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		RepoFarLeg.RepoFarLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		RepoFarLeg.RepoFarLegBuilder setSettlementAmount(Money settlementAmount);
		RepoFarLeg.RepoFarLegBuilder setSettlementCurrency(Currency settlementCurrency);
		RepoFarLeg.RepoFarLegBuilder setFxRate(FxRate fxRate);
		RepoFarLeg.RepoFarLegBuilder setDeliveryMethod(DeliveryMethod deliveryMethod);
		RepoFarLeg.RepoFarLegBuilder setDeliveryDate(AdjustableOrRelativeDate deliveryDate);
		RepoFarLeg.RepoFarLegBuilder addCollateral(CollateralValuation collateral);
		RepoFarLeg.RepoFarLegBuilder addCollateral(CollateralValuation collateral, int idx);
		RepoFarLeg.RepoFarLegBuilder addCollateral(List<? extends CollateralValuation> collateral);
		RepoFarLeg.RepoFarLegBuilder setCollateral(List<? extends CollateralValuation> collateral);
		RepoFarLeg.RepoFarLegBuilder setRepoInterest(BigDecimal repoInterest);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementAmount"), processor, Money.MoneyBuilder.class, getSettlementAmount());
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("fxRate"), processor, FxRate.FxRateBuilder.class, getFxRate());
			processRosetta(path.newSubPath("deliveryMethod"), processor, DeliveryMethod.DeliveryMethodBuilder.class, getDeliveryMethod());
			processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getDeliveryDate());
			processRosetta(path.newSubPath("collateral"), processor, CollateralValuation.CollateralValuationBuilder.class, getCollateral());
			processor.processBasic(path.newSubPath("repoInterest"), BigDecimal.class, getRepoInterest(), this);
		}
		

		RepoFarLeg.RepoFarLegBuilder prune();
	}

	/*********************** Immutable Implementation of RepoFarLeg  ***********************/
	class RepoFarLegImpl extends RepoLegBase.RepoLegBaseImpl implements RepoFarLeg {
		private final Money settlementAmount;
		private final Currency settlementCurrency;
		private final FxRate fxRate;
		private final DeliveryMethod deliveryMethod;
		private final AdjustableOrRelativeDate deliveryDate;
		private final List<? extends CollateralValuation> collateral;
		private final BigDecimal repoInterest;
		
		protected RepoFarLegImpl(RepoFarLeg.RepoFarLegBuilder builder) {
			super(builder);
			this.settlementAmount = ofNullable(builder.getSettlementAmount()).map(f->f.build()).orElse(null);
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.fxRate = ofNullable(builder.getFxRate()).map(f->f.build()).orElse(null);
			this.deliveryMethod = ofNullable(builder.getDeliveryMethod()).map(f->f.build()).orElse(null);
			this.deliveryDate = ofNullable(builder.getDeliveryDate()).map(f->f.build()).orElse(null);
			this.collateral = ofNullable(builder.getCollateral()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.repoInterest = builder.getRepoInterest();
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementAmount")
		public Money getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxRate")
		public FxRate getFxRate() {
			return fxRate;
		}
		
		@Override
		@RosettaAttribute("deliveryMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryMethod")
		public DeliveryMethod getDeliveryMethod() {
			return deliveryMethod;
		}
		
		@Override
		@RosettaAttribute("deliveryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDate")
		public AdjustableOrRelativeDate getDeliveryDate() {
			return deliveryDate;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("collateral")
		public List<? extends CollateralValuation> getCollateral() {
			return collateral;
		}
		
		@Override
		@RosettaAttribute("repoInterest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("repoInterest")
		public BigDecimal getRepoInterest() {
			return repoInterest;
		}
		
		@Override
		public RepoFarLeg build() {
			return this;
		}
		
		@Override
		public RepoFarLeg.RepoFarLegBuilder toBuilder() {
			RepoFarLeg.RepoFarLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RepoFarLeg.RepoFarLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementAmount()).ifPresent(builder::setSettlementAmount);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getFxRate()).ifPresent(builder::setFxRate);
			ofNullable(getDeliveryMethod()).ifPresent(builder::setDeliveryMethod);
			ofNullable(getDeliveryDate()).ifPresent(builder::setDeliveryDate);
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
			ofNullable(getRepoInterest()).ifPresent(builder::setRepoInterest);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RepoFarLeg _that = getType().cast(o);
		
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(fxRate, _that.getFxRate())) return false;
			if (!Objects.equals(deliveryMethod, _that.getDeliveryMethod())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!ListEquals.listEquals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(repoInterest, _that.getRepoInterest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			_result = 31 * _result + (deliveryMethod != null ? deliveryMethod.hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (repoInterest != null ? repoInterest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoFarLeg {" +
				"settlementAmount=" + this.settlementAmount + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"fxRate=" + this.fxRate + ", " +
				"deliveryMethod=" + this.deliveryMethod + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"collateral=" + this.collateral + ", " +
				"repoInterest=" + this.repoInterest +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RepoFarLeg  ***********************/
	class RepoFarLegBuilderImpl extends RepoLegBase.RepoLegBaseBuilderImpl implements RepoFarLeg.RepoFarLegBuilder {
	
		protected Money.MoneyBuilder settlementAmount;
		protected Currency.CurrencyBuilder settlementCurrency;
		protected FxRate.FxRateBuilder fxRate;
		protected DeliveryMethod.DeliveryMethodBuilder deliveryMethod;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder deliveryDate;
		protected List<CollateralValuation.CollateralValuationBuilder> collateral = new ArrayList<>();
		protected BigDecimal repoInterest;
		
		@Override
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementAmount")
		public Money.MoneyBuilder getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateSettlementAmount() {
			Money.MoneyBuilder result;
			if (settlementAmount!=null) {
				result = settlementAmount;
			}
			else {
				result = settlementAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public Currency.CurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxRate")
		public FxRate.FxRateBuilder getFxRate() {
			return fxRate;
		}
		
		@Override
		public FxRate.FxRateBuilder getOrCreateFxRate() {
			FxRate.FxRateBuilder result;
			if (fxRate!=null) {
				result = fxRate;
			}
			else {
				result = fxRate = FxRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryMethod")
		public DeliveryMethod.DeliveryMethodBuilder getDeliveryMethod() {
			return deliveryMethod;
		}
		
		@Override
		public DeliveryMethod.DeliveryMethodBuilder getOrCreateDeliveryMethod() {
			DeliveryMethod.DeliveryMethodBuilder result;
			if (deliveryMethod!=null) {
				result = deliveryMethod;
			}
			else {
				result = deliveryMethod = DeliveryMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getDeliveryDate() {
			return deliveryDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateDeliveryDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (deliveryDate!=null) {
				result = deliveryDate;
			}
			else {
				result = deliveryDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("collateral")
		public List<? extends CollateralValuation.CollateralValuationBuilder> getCollateral() {
			return collateral;
		}
		
		@Override
		public CollateralValuation.CollateralValuationBuilder getOrCreateCollateral(int index) {
			if (collateral==null) {
				this.collateral = new ArrayList<>();
			}
			return getIndex(collateral, index, () -> {
						CollateralValuation.CollateralValuationBuilder newCollateral = CollateralValuation.builder();
						return newCollateral;
					});
		}
		
		@Override
		@RosettaAttribute("repoInterest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("repoInterest")
		public BigDecimal getRepoInterest() {
			return repoInterest;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementDate")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementAmount")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setSettlementAmount(Money _settlementAmount) {
			this.settlementAmount = _settlementAmount == null ? null : _settlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxRate")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setFxRate(FxRate _fxRate) {
			this.fxRate = _fxRate == null ? null : _fxRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryMethod")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setDeliveryMethod(DeliveryMethod _deliveryMethod) {
			this.deliveryMethod = _deliveryMethod == null ? null : _deliveryMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryDate")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setDeliveryDate(AdjustableOrRelativeDate _deliveryDate) {
			this.deliveryDate = _deliveryDate == null ? null : _deliveryDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("collateral")
		@Override
		public RepoFarLeg.RepoFarLegBuilder addCollateral(CollateralValuation _collateral) {
			if (_collateral != null) {
				this.collateral.add(_collateral.toBuilder());
			}
			return this;
		}
		
		@Override
		public RepoFarLeg.RepoFarLegBuilder addCollateral(CollateralValuation _collateral, int idx) {
			getIndex(this.collateral, idx, () -> _collateral.toBuilder());
			return this;
		}
		
		@Override
		public RepoFarLeg.RepoFarLegBuilder addCollateral(List<? extends CollateralValuation> collaterals) {
			if (collaterals != null) {
				for (final CollateralValuation toAdd : collaterals) {
					this.collateral.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("collateral")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setCollateral(List<? extends CollateralValuation> collaterals) {
			if (collaterals == null) {
				this.collateral = new ArrayList<>();
			} else {
				this.collateral = collaterals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("repoInterest")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("repoInterest")
		@Override
		public RepoFarLeg.RepoFarLegBuilder setRepoInterest(BigDecimal _repoInterest) {
			this.repoInterest = _repoInterest == null ? null : _repoInterest;
			return this;
		}
		
		@Override
		public RepoFarLeg build() {
			return new RepoFarLeg.RepoFarLegImpl(this);
		}
		
		@Override
		public RepoFarLeg.RepoFarLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoFarLeg.RepoFarLegBuilder prune() {
			super.prune();
			if (settlementAmount!=null && !settlementAmount.prune().hasData()) settlementAmount = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (fxRate!=null && !fxRate.prune().hasData()) fxRate = null;
			if (deliveryMethod!=null && !deliveryMethod.prune().hasData()) deliveryMethod = null;
			if (deliveryDate!=null && !deliveryDate.prune().hasData()) deliveryDate = null;
			collateral = collateral.stream().filter(b->b!=null).<CollateralValuation.CollateralValuationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementAmount()!=null && getSettlementAmount().hasData()) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getFxRate()!=null && getFxRate().hasData()) return true;
			if (getDeliveryMethod()!=null && getDeliveryMethod().hasData()) return true;
			if (getDeliveryDate()!=null && getDeliveryDate().hasData()) return true;
			if (getCollateral()!=null && getCollateral().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRepoInterest()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoFarLeg.RepoFarLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RepoFarLeg.RepoFarLegBuilder o = (RepoFarLeg.RepoFarLegBuilder) other;
			
			merger.mergeRosetta(getSettlementAmount(), o.getSettlementAmount(), this::setSettlementAmount);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getFxRate(), o.getFxRate(), this::setFxRate);
			merger.mergeRosetta(getDeliveryMethod(), o.getDeliveryMethod(), this::setDeliveryMethod);
			merger.mergeRosetta(getDeliveryDate(), o.getDeliveryDate(), this::setDeliveryDate);
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::getOrCreateCollateral);
			
			merger.mergeBasic(getRepoInterest(), o.getRepoInterest(), this::setRepoInterest);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RepoFarLeg _that = getType().cast(o);
		
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(fxRate, _that.getFxRate())) return false;
			if (!Objects.equals(deliveryMethod, _that.getDeliveryMethod())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!ListEquals.listEquals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(repoInterest, _that.getRepoInterest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			_result = 31 * _result + (deliveryMethod != null ? deliveryMethod.hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (repoInterest != null ? repoInterest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoFarLegBuilder {" +
				"settlementAmount=" + this.settlementAmount + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"fxRate=" + this.fxRate + ", " +
				"deliveryMethod=" + this.deliveryMethod + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"collateral=" + this.collateral + ", " +
				"repoInterest=" + this.repoInterest +
			'}' + " " + super.toString();
		}
	}
}
