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
import fpml.consolidated.repo.meta.RepoNearLegMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.FxRate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
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
 * Provision A transaction leg for a repo is equivalent to a single cash transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A transaction leg for a repo is equivalent to a single cash transaction.
 *
 */
@RosettaDataType(value="RepoNearLeg", builder=RepoNearLeg.RepoNearLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RepoNearLeg", model="fpml", builder=RepoNearLeg.RepoNearLegBuilderImpl.class, version="2.1.1")
public interface RepoNearLeg extends RepoLegBase {

	RepoNearLegMeta metaData = new RepoNearLegMeta();

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

	/*********************** Build Methods  ***********************/
	RepoNearLeg build();
	
	RepoNearLeg.RepoNearLegBuilder toBuilder();
	
	static RepoNearLeg.RepoNearLegBuilder builder() {
		return new RepoNearLeg.RepoNearLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RepoNearLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RepoNearLeg> getType() {
		return RepoNearLeg.class;
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
		processRosetta(path.newSubPath("fxRate"), processor, FxRate.class, getFxRate());
		processRosetta(path.newSubPath("deliveryMethod"), processor, DeliveryMethod.class, getDeliveryMethod());
		processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableOrRelativeDate.class, getDeliveryDate());
		processRosetta(path.newSubPath("collateral"), processor, CollateralValuation.class, getCollateral());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepoNearLegBuilder extends RepoNearLeg, RepoLegBase.RepoLegBaseBuilder {
		Money.MoneyBuilder getOrCreateSettlementAmount();
		@Override
		Money.MoneyBuilder getSettlementAmount();
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
		RepoNearLeg.RepoNearLegBuilder setId(String id);
		@Override
		RepoNearLeg.RepoNearLegBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		RepoNearLeg.RepoNearLegBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		RepoNearLeg.RepoNearLegBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		RepoNearLeg.RepoNearLegBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		RepoNearLeg.RepoNearLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		RepoNearLeg.RepoNearLegBuilder setSettlementAmount(Money settlementAmount);
		RepoNearLeg.RepoNearLegBuilder setFxRate(FxRate fxRate);
		RepoNearLeg.RepoNearLegBuilder setDeliveryMethod(DeliveryMethod deliveryMethod);
		RepoNearLeg.RepoNearLegBuilder setDeliveryDate(AdjustableOrRelativeDate deliveryDate);
		RepoNearLeg.RepoNearLegBuilder addCollateral(CollateralValuation collateral);
		RepoNearLeg.RepoNearLegBuilder addCollateral(CollateralValuation collateral, int idx);
		RepoNearLeg.RepoNearLegBuilder addCollateral(List<? extends CollateralValuation> collateral);
		RepoNearLeg.RepoNearLegBuilder setCollateral(List<? extends CollateralValuation> collateral);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementAmount"), processor, Money.MoneyBuilder.class, getSettlementAmount());
			processRosetta(path.newSubPath("fxRate"), processor, FxRate.FxRateBuilder.class, getFxRate());
			processRosetta(path.newSubPath("deliveryMethod"), processor, DeliveryMethod.DeliveryMethodBuilder.class, getDeliveryMethod());
			processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getDeliveryDate());
			processRosetta(path.newSubPath("collateral"), processor, CollateralValuation.CollateralValuationBuilder.class, getCollateral());
		}
		

		RepoNearLeg.RepoNearLegBuilder prune();
	}

	/*********************** Immutable Implementation of RepoNearLeg  ***********************/
	class RepoNearLegImpl extends RepoLegBase.RepoLegBaseImpl implements RepoNearLeg {
		private final Money settlementAmount;
		private final FxRate fxRate;
		private final DeliveryMethod deliveryMethod;
		private final AdjustableOrRelativeDate deliveryDate;
		private final List<? extends CollateralValuation> collateral;
		
		protected RepoNearLegImpl(RepoNearLeg.RepoNearLegBuilder builder) {
			super(builder);
			this.settlementAmount = ofNullable(builder.getSettlementAmount()).map(f->f.build()).orElse(null);
			this.fxRate = ofNullable(builder.getFxRate()).map(f->f.build()).orElse(null);
			this.deliveryMethod = ofNullable(builder.getDeliveryMethod()).map(f->f.build()).orElse(null);
			this.deliveryDate = ofNullable(builder.getDeliveryDate()).map(f->f.build()).orElse(null);
			this.collateral = ofNullable(builder.getCollateral()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementAmount")
		public Money getSettlementAmount() {
			return settlementAmount;
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
		public RepoNearLeg build() {
			return this;
		}
		
		@Override
		public RepoNearLeg.RepoNearLegBuilder toBuilder() {
			RepoNearLeg.RepoNearLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RepoNearLeg.RepoNearLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementAmount()).ifPresent(builder::setSettlementAmount);
			ofNullable(getFxRate()).ifPresent(builder::setFxRate);
			ofNullable(getDeliveryMethod()).ifPresent(builder::setDeliveryMethod);
			ofNullable(getDeliveryDate()).ifPresent(builder::setDeliveryDate);
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RepoNearLeg _that = getType().cast(o);
		
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(fxRate, _that.getFxRate())) return false;
			if (!Objects.equals(deliveryMethod, _that.getDeliveryMethod())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!ListEquals.listEquals(collateral, _that.getCollateral())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			_result = 31 * _result + (deliveryMethod != null ? deliveryMethod.hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoNearLeg {" +
				"settlementAmount=" + this.settlementAmount + ", " +
				"fxRate=" + this.fxRate + ", " +
				"deliveryMethod=" + this.deliveryMethod + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"collateral=" + this.collateral +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RepoNearLeg  ***********************/
	class RepoNearLegBuilderImpl extends RepoLegBase.RepoLegBaseBuilderImpl implements RepoNearLeg.RepoNearLegBuilder {
	
		protected Money.MoneyBuilder settlementAmount;
		protected FxRate.FxRateBuilder fxRate;
		protected DeliveryMethod.DeliveryMethodBuilder deliveryMethod;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder deliveryDate;
		protected List<CollateralValuation.CollateralValuationBuilder> collateral = new ArrayList<>();
		
		@Override
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.GETTER)
		@Required
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public RepoNearLeg.RepoNearLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		@Override
		public RepoNearLeg.RepoNearLegBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public RepoNearLeg.RepoNearLegBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public RepoNearLeg.RepoNearLegBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public RepoNearLeg.RepoNearLegBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementDate")
		@Override
		public RepoNearLeg.RepoNearLegBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementAmount")
		@Override
		public RepoNearLeg.RepoNearLegBuilder setSettlementAmount(Money _settlementAmount) {
			this.settlementAmount = _settlementAmount == null ? null : _settlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxRate")
		@Override
		public RepoNearLeg.RepoNearLegBuilder setFxRate(FxRate _fxRate) {
			this.fxRate = _fxRate == null ? null : _fxRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryMethod")
		@Override
		public RepoNearLeg.RepoNearLegBuilder setDeliveryMethod(DeliveryMethod _deliveryMethod) {
			this.deliveryMethod = _deliveryMethod == null ? null : _deliveryMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryDate")
		@Override
		public RepoNearLeg.RepoNearLegBuilder setDeliveryDate(AdjustableOrRelativeDate _deliveryDate) {
			this.deliveryDate = _deliveryDate == null ? null : _deliveryDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("collateral")
		@Override
		public RepoNearLeg.RepoNearLegBuilder addCollateral(CollateralValuation _collateral) {
			if (_collateral != null) {
				this.collateral.add(_collateral.toBuilder());
			}
			return this;
		}
		
		@Override
		public RepoNearLeg.RepoNearLegBuilder addCollateral(CollateralValuation _collateral, int idx) {
			getIndex(this.collateral, idx, () -> _collateral.toBuilder());
			return this;
		}
		
		@Override
		public RepoNearLeg.RepoNearLegBuilder addCollateral(List<? extends CollateralValuation> collaterals) {
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
		public RepoNearLeg.RepoNearLegBuilder setCollateral(List<? extends CollateralValuation> collaterals) {
			if (collaterals == null) {
				this.collateral = new ArrayList<>();
			} else {
				this.collateral = collaterals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RepoNearLeg build() {
			return new RepoNearLeg.RepoNearLegImpl(this);
		}
		
		@Override
		public RepoNearLeg.RepoNearLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoNearLeg.RepoNearLegBuilder prune() {
			super.prune();
			if (settlementAmount!=null && !settlementAmount.prune().hasData()) settlementAmount = null;
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
			if (getFxRate()!=null && getFxRate().hasData()) return true;
			if (getDeliveryMethod()!=null && getDeliveryMethod().hasData()) return true;
			if (getDeliveryDate()!=null && getDeliveryDate().hasData()) return true;
			if (getCollateral()!=null && getCollateral().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoNearLeg.RepoNearLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RepoNearLeg.RepoNearLegBuilder o = (RepoNearLeg.RepoNearLegBuilder) other;
			
			merger.mergeRosetta(getSettlementAmount(), o.getSettlementAmount(), this::setSettlementAmount);
			merger.mergeRosetta(getFxRate(), o.getFxRate(), this::setFxRate);
			merger.mergeRosetta(getDeliveryMethod(), o.getDeliveryMethod(), this::setDeliveryMethod);
			merger.mergeRosetta(getDeliveryDate(), o.getDeliveryDate(), this::setDeliveryDate);
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::getOrCreateCollateral);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RepoNearLeg _that = getType().cast(o);
		
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(fxRate, _that.getFxRate())) return false;
			if (!Objects.equals(deliveryMethod, _that.getDeliveryMethod())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!ListEquals.listEquals(collateral, _that.getCollateral())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			_result = 31 * _result + (deliveryMethod != null ? deliveryMethod.hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoNearLegBuilder {" +
				"settlementAmount=" + this.settlementAmount + ", " +
				"fxRate=" + this.fxRate + ", " +
				"deliveryMethod=" + this.deliveryMethod + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"collateral=" + this.collateral +
			'}' + " " + super.toString();
		}
	}
}
