package fpml.consolidated.fx;

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
import fpml.consolidated.fpmlenum.FxTenorPeriodEnum;
import fpml.consolidated.fx.meta.TermDepositMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
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
 * Provision A class defining the content model for a term deposit product.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A class defining the content model for a term deposit product.
 *
 */
@RosettaDataType(value="TermDeposit", builder=TermDeposit.TermDepositBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TermDeposit", model="fpml", builder=TermDeposit.TermDepositBuilderImpl.class, version="2.1.1")
public interface TermDeposit extends Product {

	TermDepositMeta metaData = new TermDepositMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party responsible for making the payments defined by this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party responsible for making the payments defined by this structure.
	 *
	 */
	PartyReference getPayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account responsible for making the payments defined by this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account responsible for making the payments defined by this structure.
	 *
	 */
	AccountReference getPayerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that receives the payments corresponding to this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that receives the payments corresponding to this structure.
	 *
	 */
	PartyReference getReceiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that receives the payments corresponding to this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that receives the payments corresponding to this structure.
	 *
	 */
	AccountReference getReceiverAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The start date of the calculation period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The start date of the calculation period.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The end date of the calculation period. This date should already be adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The end date of the calculation period. This date should already be adjusted for any applicable business day convention.
	 *
	 */
	ZonedDateTime getMaturityDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A tenor expressed with a standard business term (i.e. Spot, TomorrowNext, etc.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A tenor expressed with a standard business term (i.e. Spot, TomorrowNext, etc.)
	 *
	 */
	FxTenorPeriodEnum getTenorName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
	 *
	 */
	Period getTenorPeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The principal amount of the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The principal amount of the trade.
	 *
	 */
	PositiveMoney getPrincipal();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 *
	 */
	BigDecimal getFixedRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The day count fraction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day count fraction.
	 *
	 */
	DayCountFraction getDayCountFraction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional container that holds additional features of the deposit (e.g. Dual Currency feature).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional container that holds additional features of the deposit (e.g. Dual Currency feature).
	 *
	 */
	TermDepositFeatures getFeatures();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The total interest of at maturity of the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The total interest of at maturity of the trade.
	 *
	 */
	Money getInterest();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A known payment between two parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A known payment between two parties.
	 *
	 */
	List<? extends Payment> getPayment();

	/*********************** Build Methods  ***********************/
	TermDeposit build();
	
	TermDeposit.TermDepositBuilder toBuilder();
	
	static TermDeposit.TermDepositBuilder builder() {
		return new TermDeposit.TermDepositBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TermDeposit> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TermDeposit> getType() {
		return TermDeposit.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.class, getSecondaryAssetClass());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("productId"), processor, ProductId.class, getProductId());
		processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.class, getEmbeddedOptionType());
		processRosetta(path.newSubPath("assetClass"), processor, AssetClass.class, getAssetClass());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
		processor.processBasic(path.newSubPath("tenorName"), FxTenorPeriodEnum.class, getTenorName(), this);
		processRosetta(path.newSubPath("tenorPeriod"), processor, Period.class, getTenorPeriod());
		processRosetta(path.newSubPath("principal"), processor, PositiveMoney.class, getPrincipal());
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("features"), processor, TermDepositFeatures.class, getFeatures());
		processRosetta(path.newSubPath("interest"), processor, Money.class, getInterest());
		processRosetta(path.newSubPath("payment"), processor, Payment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TermDepositBuilder extends TermDeposit, Product.ProductBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getPayerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReceiverPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getReceiverAccountReference();
		Period.PeriodBuilder getOrCreateTenorPeriod();
		@Override
		Period.PeriodBuilder getTenorPeriod();
		PositiveMoney.PositiveMoneyBuilder getOrCreatePrincipal();
		@Override
		PositiveMoney.PositiveMoneyBuilder getPrincipal();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		TermDepositFeatures.TermDepositFeaturesBuilder getOrCreateFeatures();
		@Override
		TermDepositFeatures.TermDepositFeaturesBuilder getFeatures();
		Money.MoneyBuilder getOrCreateInterest();
		@Override
		Money.MoneyBuilder getInterest();
		Payment.PaymentBuilder getOrCreatePayment(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getPayment();
		@Override
		TermDeposit.TermDepositBuilder setId(String id);
		@Override
		TermDeposit.TermDepositBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		TermDeposit.TermDepositBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		TermDeposit.TermDepositBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		TermDeposit.TermDepositBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		TermDeposit.TermDepositBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		TermDeposit.TermDepositBuilder addProductType(ProductType productType);
		@Override
		TermDeposit.TermDepositBuilder addProductType(ProductType productType, int idx);
		@Override
		TermDeposit.TermDepositBuilder addProductType(List<? extends ProductType> productType);
		@Override
		TermDeposit.TermDepositBuilder setProductType(List<? extends ProductType> productType);
		@Override
		TermDeposit.TermDepositBuilder addProductId(ProductId productId);
		@Override
		TermDeposit.TermDepositBuilder addProductId(ProductId productId, int idx);
		@Override
		TermDeposit.TermDepositBuilder addProductId(List<? extends ProductId> productId);
		@Override
		TermDeposit.TermDepositBuilder setProductId(List<? extends ProductId> productId);
		@Override
		TermDeposit.TermDepositBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		TermDeposit.TermDepositBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		TermDeposit.TermDepositBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		TermDeposit.TermDepositBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		TermDeposit.TermDepositBuilder addAssetClass(AssetClass assetClass);
		@Override
		TermDeposit.TermDepositBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		TermDeposit.TermDepositBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		TermDeposit.TermDepositBuilder setAssetClass(List<? extends AssetClass> assetClass);
		TermDeposit.TermDepositBuilder setPayerPartyReference(PartyReference payerPartyReference);
		TermDeposit.TermDepositBuilder setPayerAccountReference(AccountReference payerAccountReference);
		TermDeposit.TermDepositBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		TermDeposit.TermDepositBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		TermDeposit.TermDepositBuilder setStartDate(ZonedDateTime startDate);
		TermDeposit.TermDepositBuilder setMaturityDate(ZonedDateTime maturityDate);
		TermDeposit.TermDepositBuilder setTenorName(FxTenorPeriodEnum tenorName);
		TermDeposit.TermDepositBuilder setTenorPeriod(Period tenorPeriod);
		TermDeposit.TermDepositBuilder setPrincipal(PositiveMoney principal);
		TermDeposit.TermDepositBuilder setFixedRate(BigDecimal fixedRate);
		TermDeposit.TermDepositBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		TermDeposit.TermDepositBuilder setFeatures(TermDepositFeatures features);
		TermDeposit.TermDepositBuilder setInterest(Money interest);
		TermDeposit.TermDepositBuilder addPayment(Payment payment);
		TermDeposit.TermDepositBuilder addPayment(Payment payment, int idx);
		TermDeposit.TermDepositBuilder addPayment(List<? extends Payment> payment);
		TermDeposit.TermDepositBuilder setPayment(List<? extends Payment> payment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
			processor.processBasic(path.newSubPath("tenorName"), FxTenorPeriodEnum.class, getTenorName(), this);
			processRosetta(path.newSubPath("tenorPeriod"), processor, Period.PeriodBuilder.class, getTenorPeriod());
			processRosetta(path.newSubPath("principal"), processor, PositiveMoney.PositiveMoneyBuilder.class, getPrincipal());
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("features"), processor, TermDepositFeatures.TermDepositFeaturesBuilder.class, getFeatures());
			processRosetta(path.newSubPath("interest"), processor, Money.MoneyBuilder.class, getInterest());
			processRosetta(path.newSubPath("payment"), processor, Payment.PaymentBuilder.class, getPayment());
		}
		

		TermDeposit.TermDepositBuilder prune();
	}

	/*********************** Immutable Implementation of TermDeposit  ***********************/
	class TermDepositImpl extends Product.ProductImpl implements TermDeposit {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final ZonedDateTime startDate;
		private final ZonedDateTime maturityDate;
		private final FxTenorPeriodEnum tenorName;
		private final Period tenorPeriod;
		private final PositiveMoney principal;
		private final BigDecimal fixedRate;
		private final DayCountFraction dayCountFraction;
		private final TermDepositFeatures features;
		private final Money interest;
		private final List<? extends Payment> payment;
		
		protected TermDepositImpl(TermDeposit.TermDepositBuilder builder) {
			super(builder);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.startDate = builder.getStartDate();
			this.maturityDate = builder.getMaturityDate();
			this.tenorName = builder.getTenorName();
			this.tenorPeriod = ofNullable(builder.getTenorPeriod()).map(f->f.build()).orElse(null);
			this.principal = ofNullable(builder.getPrincipal()).map(f->f.build()).orElse(null);
			this.fixedRate = builder.getFixedRate();
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.features = ofNullable(builder.getFeatures()).map(f->f.build()).orElse(null);
			this.interest = ofNullable(builder.getInterest()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		public PartyReference getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerAccountReference")
		public AccountReference getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverAccountReference")
		public AccountReference getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDate")
		public ZonedDateTime getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("tenorName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenorName")
		public FxTenorPeriodEnum getTenorName() {
			return tenorName;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenorPeriod")
		public Period getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		@RosettaAttribute("principal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principal")
		public PositiveMoney getPrincipal() {
			return principal;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("features")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("features")
		public TermDepositFeatures getFeatures() {
			return features;
		}
		
		@Override
		@RosettaAttribute("interest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interest")
		public Money getInterest() {
			return interest;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("payment")
		public List<? extends Payment> getPayment() {
			return payment;
		}
		
		@Override
		public TermDeposit build() {
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder toBuilder() {
			TermDeposit.TermDepositBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TermDeposit.TermDepositBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getMaturityDate()).ifPresent(builder::setMaturityDate);
			ofNullable(getTenorName()).ifPresent(builder::setTenorName);
			ofNullable(getTenorPeriod()).ifPresent(builder::setTenorPeriod);
			ofNullable(getPrincipal()).ifPresent(builder::setPrincipal);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getFeatures()).ifPresent(builder::setFeatures);
			ofNullable(getInterest()).ifPresent(builder::setInterest);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TermDeposit _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			if (!Objects.equals(tenorName, _that.getTenorName())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(principal, _that.getPrincipal())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(features, _that.getFeatures())) return false;
			if (!Objects.equals(interest, _that.getInterest())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			_result = 31 * _result + (tenorName != null ? tenorName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (principal != null ? principal.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (features != null ? features.hashCode() : 0);
			_result = 31 * _result + (interest != null ? interest.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermDeposit {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"startDate=" + this.startDate + ", " +
				"maturityDate=" + this.maturityDate + ", " +
				"tenorName=" + this.tenorName + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"principal=" + this.principal + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"features=" + this.features + ", " +
				"interest=" + this.interest + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TermDeposit  ***********************/
	class TermDepositBuilderImpl extends Product.ProductBuilderImpl implements TermDeposit.TermDepositBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected ZonedDateTime startDate;
		protected ZonedDateTime maturityDate;
		protected FxTenorPeriodEnum tenorName;
		protected Period.PeriodBuilder tenorPeriod;
		protected PositiveMoney.PositiveMoneyBuilder principal;
		protected BigDecimal fixedRate;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected TermDepositFeatures.TermDepositFeaturesBuilder features;
		protected Money.MoneyBuilder interest;
		protected List<Payment.PaymentBuilder> payment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		public PartyReference.PartyReferenceBuilder getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (payerPartyReference!=null) {
				result = payerPartyReference;
			}
			else {
				result = payerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerAccountReference")
		public AccountReference.AccountReferenceBuilder getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (payerAccountReference!=null) {
				result = payerAccountReference;
			}
			else {
				result = payerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference.PartyReferenceBuilder getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (receiverPartyReference!=null) {
				result = receiverPartyReference;
			}
			else {
				result = receiverPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverAccountReference")
		public AccountReference.AccountReferenceBuilder getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (receiverAccountReference!=null) {
				result = receiverAccountReference;
			}
			else {
				result = receiverAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDate")
		public ZonedDateTime getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("tenorName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenorName")
		public FxTenorPeriodEnum getTenorName() {
			return tenorName;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenorPeriod")
		public Period.PeriodBuilder getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenorPeriod() {
			Period.PeriodBuilder result;
			if (tenorPeriod!=null) {
				result = tenorPeriod;
			}
			else {
				result = tenorPeriod = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principal")
		public PositiveMoney.PositiveMoneyBuilder getPrincipal() {
			return principal;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreatePrincipal() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (principal!=null) {
				result = principal;
			}
			else {
				result = principal = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("features")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("features")
		public TermDepositFeatures.TermDepositFeaturesBuilder getFeatures() {
			return features;
		}
		
		@Override
		public TermDepositFeatures.TermDepositFeaturesBuilder getOrCreateFeatures() {
			TermDepositFeatures.TermDepositFeaturesBuilder result;
			if (features!=null) {
				result = features;
			}
			else {
				result = features = TermDepositFeatures.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interest")
		public Money.MoneyBuilder getInterest() {
			return interest;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateInterest() {
			Money.MoneyBuilder result;
			if (interest!=null) {
				result = interest;
			}
			else {
				result = interest = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("payment")
		public List<? extends Payment.PaymentBuilder> getPayment() {
			return payment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreatePayment(int index) {
			if (payment==null) {
				this.payment = new ArrayList<>();
			}
			return getIndex(payment, index, () -> {
						Payment.PaymentBuilder newPayment = Payment.builder();
						return newPayment;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public TermDeposit.TermDepositBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public TermDeposit.TermDepositBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public TermDeposit.TermDepositBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss != null) {
				for (final AssetClass toAdd : secondaryAssetClasss) {
					this.secondaryAssetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public TermDeposit.TermDepositBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss == null) {
				this.secondaryAssetClass = new ArrayList<>();
			} else {
				this.secondaryAssetClass = secondaryAssetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public TermDeposit.TermDepositBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addProductType(List<? extends ProductType> productTypes) {
			if (productTypes != null) {
				for (final ProductType toAdd : productTypes) {
					this.productType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public TermDeposit.TermDepositBuilder setProductType(List<? extends ProductType> productTypes) {
			if (productTypes == null) {
				this.productType = new ArrayList<>();
			} else {
				this.productType = productTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public TermDeposit.TermDepositBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addProductId(List<? extends ProductId> productIds) {
			if (productIds != null) {
				for (final ProductId toAdd : productIds) {
					this.productId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public TermDeposit.TermDepositBuilder setProductId(List<? extends ProductId> productIds) {
			if (productIds == null) {
				this.productId = new ArrayList<>();
			} else {
				this.productId = productIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public TermDeposit.TermDepositBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes != null) {
				for (final EmbeddedOptionType toAdd : embeddedOptionTypes) {
					this.embeddedOptionType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public TermDeposit.TermDepositBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes == null) {
				this.embeddedOptionType = new ArrayList<>();
			} else {
				this.embeddedOptionType = embeddedOptionTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public TermDeposit.TermDepositBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss != null) {
				for (final AssetClass toAdd : assetClasss) {
					this.assetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public TermDeposit.TermDepositBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public TermDeposit.TermDepositBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public TermDeposit.TermDepositBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public TermDeposit.TermDepositBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public TermDeposit.TermDepositBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startDate")
		@Override
		public TermDeposit.TermDepositBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDate")
		@Override
		public TermDeposit.TermDepositBuilder setMaturityDate(ZonedDateTime _maturityDate) {
			this.maturityDate = _maturityDate == null ? null : _maturityDate;
			return this;
		}
		
		@RosettaAttribute("tenorName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tenorName")
		@Override
		public TermDeposit.TermDepositBuilder setTenorName(FxTenorPeriodEnum _tenorName) {
			this.tenorName = _tenorName == null ? null : _tenorName;
			return this;
		}
		
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tenorPeriod")
		@Override
		public TermDeposit.TermDepositBuilder setTenorPeriod(Period _tenorPeriod) {
			this.tenorPeriod = _tenorPeriod == null ? null : _tenorPeriod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("principal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("principal")
		@Override
		public TermDeposit.TermDepositBuilder setPrincipal(PositiveMoney _principal) {
			this.principal = _principal == null ? null : _principal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public TermDeposit.TermDepositBuilder setFixedRate(BigDecimal _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate;
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public TermDeposit.TermDepositBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("features")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("features")
		@Override
		public TermDeposit.TermDepositBuilder setFeatures(TermDepositFeatures _features) {
			this.features = _features == null ? null : _features.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interest")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interest")
		@Override
		public TermDeposit.TermDepositBuilder setInterest(Money _interest) {
			this.interest = _interest == null ? null : _interest.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public TermDeposit.TermDepositBuilder addPayment(Payment _payment) {
			if (_payment != null) {
				this.payment.add(_payment.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addPayment(Payment _payment, int idx) {
			getIndex(this.payment, idx, () -> _payment.toBuilder());
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addPayment(List<? extends Payment> payments) {
			if (payments != null) {
				for (final Payment toAdd : payments) {
					this.payment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public TermDeposit.TermDepositBuilder setPayment(List<? extends Payment> payments) {
			if (payments == null) {
				this.payment = new ArrayList<>();
			} else {
				this.payment = payments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TermDeposit build() {
			return new TermDeposit.TermDepositImpl(this);
		}
		
		@Override
		public TermDeposit.TermDepositBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermDeposit.TermDepositBuilder prune() {
			super.prune();
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (tenorPeriod!=null && !tenorPeriod.prune().hasData()) tenorPeriod = null;
			if (principal!=null && !principal.prune().hasData()) principal = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (features!=null && !features.prune().hasData()) features = null;
			if (interest!=null && !interest.prune().hasData()) interest = null;
			payment = payment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getMaturityDate()!=null) return true;
			if (getTenorName()!=null) return true;
			if (getTenorPeriod()!=null && getTenorPeriod().hasData()) return true;
			if (getPrincipal()!=null && getPrincipal().hasData()) return true;
			if (getFixedRate()!=null) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getFeatures()!=null && getFeatures().hasData()) return true;
			if (getInterest()!=null && getInterest().hasData()) return true;
			if (getPayment()!=null && getPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermDeposit.TermDepositBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TermDeposit.TermDepositBuilder o = (TermDeposit.TermDepositBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getTenorPeriod(), o.getTenorPeriod(), this::setTenorPeriod);
			merger.mergeRosetta(getPrincipal(), o.getPrincipal(), this::setPrincipal);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getFeatures(), o.getFeatures(), this::setFeatures);
			merger.mergeRosetta(getInterest(), o.getInterest(), this::setInterest);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::getOrCreatePayment);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getMaturityDate(), o.getMaturityDate(), this::setMaturityDate);
			merger.mergeBasic(getTenorName(), o.getTenorName(), this::setTenorName);
			merger.mergeBasic(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TermDeposit _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			if (!Objects.equals(tenorName, _that.getTenorName())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(principal, _that.getPrincipal())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(features, _that.getFeatures())) return false;
			if (!Objects.equals(interest, _that.getInterest())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			_result = 31 * _result + (tenorName != null ? tenorName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (principal != null ? principal.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (features != null ? features.hashCode() : 0);
			_result = 31 * _result + (interest != null ? interest.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermDepositBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"startDate=" + this.startDate + ", " +
				"maturityDate=" + this.maturityDate + ", " +
				"tenorName=" + this.tenorName + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"principal=" + this.principal + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"features=" + this.features + ", " +
				"interest=" + this.interest + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}
}
