package fpml.consolidated.generic;

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
import fpml.consolidated.asset.Asset;
import fpml.consolidated.cd.IndexReferenceInformation;
import fpml.consolidated.com.CoalProduct;
import fpml.consolidated.com.ElectricityProduct;
import fpml.consolidated.com.GasProduct;
import fpml.consolidated.com.OilProduct;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.generic.meta.TradeUnderlyer2Meta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.FloatingRate;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.QuotedCurrencyPair;
import fpml.consolidated.shared.Schedule;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The underlying asset/index/reference price etc. whose rate/price may be observed to compute the value of the cashflow. It can be an index, fixed rate, listed security, quoted currency pair, or a reference entity (for credit derivatives). For use with Generic products in Transparency reporting. Generic products define a product that represents an OTC derivative transaction whose economics are not fully described using an FpML schema. In other views, generic products are present for convenience to support internal messaging and workflows that are cross-product. Generic products are not full trade representations as such they are not intended to be used for confirming trades.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The underlying asset/index/reference price etc. whose rate/price may be observed to compute the value of the cashflow. It can be an index, fixed rate, listed security, quoted currency pair, or a reference entity (for credit derivatives). For use with Generic products in Transparency reporting. Generic products define a product that represents an OTC derivative transaction whose economics are not fully described using an FpML schema. In other views, generic products are present for convenience to support internal messaging and workflows that are cross-product. Generic products are not full trade representations as such they are not intended to be used for confirming trades.
 *
 */
@RosettaDataType(value="TradeUnderlyer2", builder=TradeUnderlyer2.TradeUnderlyer2BuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeUnderlyer2", model="fpml", builder=TradeUnderlyer2.TradeUnderlyer2BuilderImpl.class, version="2.1.1")
public interface TradeUnderlyer2 extends RosettaModelObject {

	TradeUnderlyer2Meta metaData = new TradeUnderlyer2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A floating rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A floating rate.
	 *
	 */
	FloatingRate getFloatingRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The fixed rate or fixed rate schedule expressed as explicit fixed rates and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The fixed rate or fixed rate schedule expressed as explicit fixed rates and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 */
	Schedule getFixedRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The rate of exchange between two currencies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The rate of exchange between two currencies.
	 *
	 */
	GenericProductExchangeRate getExchangeRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Define the underlying asset, either a listed security or other instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Define the underlying asset, either a listed security or other instrument.
	 *
	 */
	Asset getUnderlyingAsset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes the composition of a rate that has been quoted. This includes the two currencies and the quotation relationship between the two currencies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the composition of a rate that has been quoted. This includes the two currencies and the quotation relationship between the two currencies.
	 *
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The corporate or sovereign entity on which you are buying or selling protection and any successor that assumes all or substantially all of its contractual and other obligations. It is vital to use the correct legal name of the entity and to be careful not to choose a subsidiary if you really want to trade protection on a parent company. Please note, Reference Entities cannot be senior or subordinated. It is the obligations of the Reference Entities that can be senior or subordinated. ISDA 2003 Term: Reference Entity
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The corporate or sovereign entity on which you are buying or selling protection and any successor that assumes all or substantially all of its contractual and other obligations. It is vital to use the correct legal name of the entity and to be careful not to choose a subsidiary if you really want to trade protection on a parent company. Please note, Reference Entities cannot be senior or subordinated. It is the obligations of the Reference Entities that can be senior or subordinated. ISDA 2003 Term: Reference Entity
	 *
	 */
	LegalEntity getReferenceEntity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the terms relevant to defining the Credit DefaultSwap Index.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the terms relevant to defining the Credit DefaultSwap Index.
	 *
	 */
	IndexReferenceInformation getIndexReferenceInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification of the gas to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of the gas to be delivered.
	 *
	 */
	GasProduct getGas();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification of the oil product to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of the oil product to be delivered.
	 *
	 */
	OilProduct getOil();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification of the Coal Product to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of the Coal Product to be delivered.
	 *
	 */
	CoalProduct getCoal();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification of the electricity to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of the electricity to be delivered.
	 *
	 */
	ElectricityProduct getElectricity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parties may specify a Method of Averaging where more than one pricing Dates is being specified as being applicable. This defines the averaging method applicable to this asset (used for Commodities).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parties may specify a Method of Averaging where more than one pricing Dates is being specified as being applicable. This defines the averaging method applicable to this asset (used for Commodities).
	 *
	 */
	AveragingMethodEnum getAveragingMethod();
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
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 */
	AccountReference getBuyerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 */
	PartyReference getSellerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 */
	AccountReference getSellerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a day count fraction or fractions that apply to this underlyer; this is provided to meet regulatory reporting requirements, but is not sufficient to to fully represent the economics of the trade..
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies a day count fraction or fractions that apply to this underlyer; this is provided to meet regulatory reporting requirements, but is not sufficient to to fully represent the economics of the trade..
	 *
	 */
	DayCountFraction getDayCountFraction();

	/*********************** Build Methods  ***********************/
	TradeUnderlyer2 build();
	
	TradeUnderlyer2.TradeUnderlyer2Builder toBuilder();
	
	static TradeUnderlyer2.TradeUnderlyer2Builder builder() {
		return new TradeUnderlyer2.TradeUnderlyer2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeUnderlyer2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeUnderlyer2> getType() {
		return TradeUnderlyer2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("floatingRate"), processor, FloatingRate.class, getFloatingRate());
		processRosetta(path.newSubPath("fixedRate"), processor, Schedule.class, getFixedRate());
		processRosetta(path.newSubPath("exchangeRate"), processor, GenericProductExchangeRate.class, getExchangeRate());
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.class, getReferenceEntity());
		processRosetta(path.newSubPath("indexReferenceInformation"), processor, IndexReferenceInformation.class, getIndexReferenceInformation());
		processRosetta(path.newSubPath("gas"), processor, GasProduct.class, getGas());
		processRosetta(path.newSubPath("oil"), processor, OilProduct.class, getOil());
		processRosetta(path.newSubPath("coal"), processor, CoalProduct.class, getCoal());
		processRosetta(path.newSubPath("electricity"), processor, ElectricityProduct.class, getElectricity());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.class, getBuyerAccountReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.class, getSellerAccountReference());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeUnderlyer2Builder extends TradeUnderlyer2, RosettaModelObjectBuilder {
		FloatingRate.FloatingRateBuilder getOrCreateFloatingRate();
		@Override
		FloatingRate.FloatingRateBuilder getFloatingRate();
		Schedule.ScheduleBuilder getOrCreateFixedRate();
		@Override
		Schedule.ScheduleBuilder getFixedRate();
		GenericProductExchangeRate.GenericProductExchangeRateBuilder getOrCreateExchangeRate();
		@Override
		GenericProductExchangeRate.GenericProductExchangeRateBuilder getExchangeRate();
		Asset.AssetBuilder getOrCreateUnderlyingAsset();
		@Override
		Asset.AssetBuilder getUnderlyingAsset();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity();
		@Override
		LegalEntity.LegalEntityBuilder getReferenceEntity();
		IndexReferenceInformation.IndexReferenceInformationBuilder getOrCreateIndexReferenceInformation();
		@Override
		IndexReferenceInformation.IndexReferenceInformationBuilder getIndexReferenceInformation();
		GasProduct.GasProductBuilder getOrCreateGas();
		@Override
		GasProduct.GasProductBuilder getGas();
		OilProduct.OilProductBuilder getOrCreateOil();
		@Override
		OilProduct.OilProductBuilder getOil();
		CoalProduct.CoalProductBuilder getOrCreateCoal();
		@Override
		CoalProduct.CoalProductBuilder getCoal();
		ElectricityProduct.ElectricityProductBuilder getOrCreateElectricity();
		@Override
		ElectricityProduct.ElectricityProductBuilder getElectricity();
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
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getBuyerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getSellerAccountReference();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		TradeUnderlyer2.TradeUnderlyer2Builder setId(String id);
		TradeUnderlyer2.TradeUnderlyer2Builder setFloatingRate(FloatingRate floatingRate);
		TradeUnderlyer2.TradeUnderlyer2Builder setFixedRate(Schedule fixedRate);
		TradeUnderlyer2.TradeUnderlyer2Builder setExchangeRate(GenericProductExchangeRate exchangeRate);
		TradeUnderlyer2.TradeUnderlyer2Builder setUnderlyingAsset(Asset underlyingAsset);
		TradeUnderlyer2.TradeUnderlyer2Builder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		TradeUnderlyer2.TradeUnderlyer2Builder setReferenceEntity(LegalEntity referenceEntity);
		TradeUnderlyer2.TradeUnderlyer2Builder setIndexReferenceInformation(IndexReferenceInformation indexReferenceInformation);
		TradeUnderlyer2.TradeUnderlyer2Builder setGas(GasProduct gas);
		TradeUnderlyer2.TradeUnderlyer2Builder setOil(OilProduct oil);
		TradeUnderlyer2.TradeUnderlyer2Builder setCoal(CoalProduct coal);
		TradeUnderlyer2.TradeUnderlyer2Builder setElectricity(ElectricityProduct electricity);
		TradeUnderlyer2.TradeUnderlyer2Builder setAveragingMethod(AveragingMethodEnum averagingMethod);
		TradeUnderlyer2.TradeUnderlyer2Builder setPayerPartyReference(PartyReference payerPartyReference);
		TradeUnderlyer2.TradeUnderlyer2Builder setPayerAccountReference(AccountReference payerAccountReference);
		TradeUnderlyer2.TradeUnderlyer2Builder setReceiverPartyReference(PartyReference receiverPartyReference);
		TradeUnderlyer2.TradeUnderlyer2Builder setReceiverAccountReference(AccountReference receiverAccountReference);
		TradeUnderlyer2.TradeUnderlyer2Builder setBuyerPartyReference(PartyReference buyerPartyReference);
		TradeUnderlyer2.TradeUnderlyer2Builder setBuyerAccountReference(AccountReference buyerAccountReference);
		TradeUnderlyer2.TradeUnderlyer2Builder setSellerPartyReference(PartyReference sellerPartyReference);
		TradeUnderlyer2.TradeUnderlyer2Builder setSellerAccountReference(AccountReference sellerAccountReference);
		TradeUnderlyer2.TradeUnderlyer2Builder setDayCountFraction(DayCountFraction dayCountFraction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("floatingRate"), processor, FloatingRate.FloatingRateBuilder.class, getFloatingRate());
			processRosetta(path.newSubPath("fixedRate"), processor, Schedule.ScheduleBuilder.class, getFixedRate());
			processRosetta(path.newSubPath("exchangeRate"), processor, GenericProductExchangeRate.GenericProductExchangeRateBuilder.class, getExchangeRate());
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.LegalEntityBuilder.class, getReferenceEntity());
			processRosetta(path.newSubPath("indexReferenceInformation"), processor, IndexReferenceInformation.IndexReferenceInformationBuilder.class, getIndexReferenceInformation());
			processRosetta(path.newSubPath("gas"), processor, GasProduct.GasProductBuilder.class, getGas());
			processRosetta(path.newSubPath("oil"), processor, OilProduct.OilProductBuilder.class, getOil());
			processRosetta(path.newSubPath("coal"), processor, CoalProduct.CoalProductBuilder.class, getCoal());
			processRosetta(path.newSubPath("electricity"), processor, ElectricityProduct.ElectricityProductBuilder.class, getElectricity());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
		}
		

		TradeUnderlyer2.TradeUnderlyer2Builder prune();
	}

	/*********************** Immutable Implementation of TradeUnderlyer2  ***********************/
	class TradeUnderlyer2Impl implements TradeUnderlyer2 {
		private final String id;
		private final FloatingRate floatingRate;
		private final Schedule fixedRate;
		private final GenericProductExchangeRate exchangeRate;
		private final Asset underlyingAsset;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final LegalEntity referenceEntity;
		private final IndexReferenceInformation indexReferenceInformation;
		private final GasProduct gas;
		private final OilProduct oil;
		private final CoalProduct coal;
		private final ElectricityProduct electricity;
		private final AveragingMethodEnum averagingMethod;
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final DayCountFraction dayCountFraction;
		
		protected TradeUnderlyer2Impl(TradeUnderlyer2.TradeUnderlyer2Builder builder) {
			this.id = builder.getId();
			this.floatingRate = ofNullable(builder.getFloatingRate()).map(f->f.build()).orElse(null);
			this.fixedRate = ofNullable(builder.getFixedRate()).map(f->f.build()).orElse(null);
			this.exchangeRate = ofNullable(builder.getExchangeRate()).map(f->f.build()).orElse(null);
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).map(f->f.build()).orElse(null);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.referenceEntity = ofNullable(builder.getReferenceEntity()).map(f->f.build()).orElse(null);
			this.indexReferenceInformation = ofNullable(builder.getIndexReferenceInformation()).map(f->f.build()).orElse(null);
			this.gas = ofNullable(builder.getGas()).map(f->f.build()).orElse(null);
			this.oil = ofNullable(builder.getOil()).map(f->f.build()).orElse(null);
			this.coal = ofNullable(builder.getCoal()).map(f->f.build()).orElse(null);
			this.electricity = ofNullable(builder.getElectricity()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("floatingRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRate")
		public FloatingRate getFloatingRate() {
			return floatingRate;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public Schedule getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeRate")
		public GenericProductExchangeRate getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAsset")
		public Asset getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceEntity")
		public LegalEntity getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexReferenceInformation")
		public IndexReferenceInformation getIndexReferenceInformation() {
			return indexReferenceInformation;
		}
		
		@Override
		@RosettaAttribute("gas")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("gas")
		public GasProduct getGas() {
			return gas;
		}
		
		@Override
		@RosettaAttribute("oil")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("oil")
		public OilProduct getOil() {
			return oil;
		}
		
		@Override
		@RosettaAttribute("coal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coal")
		public CoalProduct getCoal() {
			return coal;
		}
		
		@Override
		@RosettaAttribute("electricity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("electricity")
		public ElectricityProduct getElectricity() {
			return electricity;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public TradeUnderlyer2 build() {
			return this;
		}
		
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder toBuilder() {
			TradeUnderlyer2.TradeUnderlyer2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeUnderlyer2.TradeUnderlyer2Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getFloatingRate()).ifPresent(builder::setFloatingRate);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getExchangeRate()).ifPresent(builder::setExchangeRate);
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getReferenceEntity()).ifPresent(builder::setReferenceEntity);
			ofNullable(getIndexReferenceInformation()).ifPresent(builder::setIndexReferenceInformation);
			ofNullable(getGas()).ifPresent(builder::setGas);
			ofNullable(getOil()).ifPresent(builder::setOil);
			ofNullable(getCoal()).ifPresent(builder::setCoal);
			ofNullable(getElectricity()).ifPresent(builder::setElectricity);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeUnderlyer2 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(floatingRate, _that.getFloatingRate())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(exchangeRate, _that.getExchangeRate())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(indexReferenceInformation, _that.getIndexReferenceInformation())) return false;
			if (!Objects.equals(gas, _that.getGas())) return false;
			if (!Objects.equals(oil, _that.getOil())) return false;
			if (!Objects.equals(coal, _that.getCoal())) return false;
			if (!Objects.equals(electricity, _that.getElectricity())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (floatingRate != null ? floatingRate.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformation != null ? indexReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (gas != null ? gas.hashCode() : 0);
			_result = 31 * _result + (oil != null ? oil.hashCode() : 0);
			_result = 31 * _result + (coal != null ? coal.hashCode() : 0);
			_result = 31 * _result + (electricity != null ? electricity.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeUnderlyer2 {" +
				"id=" + this.id + ", " +
				"floatingRate=" + this.floatingRate + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"exchangeRate=" + this.exchangeRate + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"referenceEntity=" + this.referenceEntity + ", " +
				"indexReferenceInformation=" + this.indexReferenceInformation + ", " +
				"gas=" + this.gas + ", " +
				"oil=" + this.oil + ", " +
				"coal=" + this.coal + ", " +
				"electricity=" + this.electricity + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeUnderlyer2  ***********************/
	class TradeUnderlyer2BuilderImpl implements TradeUnderlyer2.TradeUnderlyer2Builder {
	
		protected String id;
		protected FloatingRate.FloatingRateBuilder floatingRate;
		protected Schedule.ScheduleBuilder fixedRate;
		protected GenericProductExchangeRate.GenericProductExchangeRateBuilder exchangeRate;
		protected Asset.AssetBuilder underlyingAsset;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected LegalEntity.LegalEntityBuilder referenceEntity;
		protected IndexReferenceInformation.IndexReferenceInformationBuilder indexReferenceInformation;
		protected GasProduct.GasProductBuilder gas;
		protected OilProduct.OilProductBuilder oil;
		protected CoalProduct.CoalProductBuilder coal;
		protected ElectricityProduct.ElectricityProductBuilder electricity;
		protected AveragingMethodEnum averagingMethod;
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("floatingRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRate")
		public FloatingRate.FloatingRateBuilder getFloatingRate() {
			return floatingRate;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder getOrCreateFloatingRate() {
			FloatingRate.FloatingRateBuilder result;
			if (floatingRate!=null) {
				result = floatingRate;
			}
			else {
				result = floatingRate = FloatingRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public Schedule.ScheduleBuilder getFixedRate() {
			return fixedRate;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFixedRate() {
			Schedule.ScheduleBuilder result;
			if (fixedRate!=null) {
				result = fixedRate;
			}
			else {
				result = fixedRate = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeRate")
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder getOrCreateExchangeRate() {
			GenericProductExchangeRate.GenericProductExchangeRateBuilder result;
			if (exchangeRate!=null) {
				result = exchangeRate;
			}
			else {
				result = exchangeRate = GenericProductExchangeRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAsset")
		public Asset.AssetBuilder getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlyingAsset() {
			Asset.AssetBuilder result;
			if (underlyingAsset!=null) {
				result = underlyingAsset;
			}
			else {
				result = underlyingAsset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceEntity")
		public LegalEntity.LegalEntityBuilder getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity() {
			LegalEntity.LegalEntityBuilder result;
			if (referenceEntity!=null) {
				result = referenceEntity;
			}
			else {
				result = referenceEntity = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexReferenceInformation")
		public IndexReferenceInformation.IndexReferenceInformationBuilder getIndexReferenceInformation() {
			return indexReferenceInformation;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder getOrCreateIndexReferenceInformation() {
			IndexReferenceInformation.IndexReferenceInformationBuilder result;
			if (indexReferenceInformation!=null) {
				result = indexReferenceInformation;
			}
			else {
				result = indexReferenceInformation = IndexReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("gas")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("gas")
		public GasProduct.GasProductBuilder getGas() {
			return gas;
		}
		
		@Override
		public GasProduct.GasProductBuilder getOrCreateGas() {
			GasProduct.GasProductBuilder result;
			if (gas!=null) {
				result = gas;
			}
			else {
				result = gas = GasProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("oil")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("oil")
		public OilProduct.OilProductBuilder getOil() {
			return oil;
		}
		
		@Override
		public OilProduct.OilProductBuilder getOrCreateOil() {
			OilProduct.OilProductBuilder result;
			if (oil!=null) {
				result = oil;
			}
			else {
				result = oil = OilProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coal")
		public CoalProduct.CoalProductBuilder getCoal() {
			return coal;
		}
		
		@Override
		public CoalProduct.CoalProductBuilder getOrCreateCoal() {
			CoalProduct.CoalProductBuilder result;
			if (coal!=null) {
				result = coal;
			}
			else {
				result = coal = CoalProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("electricity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("electricity")
		public ElectricityProduct.ElectricityProductBuilder getElectricity() {
			return electricity;
		}
		
		@Override
		public ElectricityProduct.ElectricityProductBuilder getOrCreateElectricity() {
			ElectricityProduct.ElectricityProductBuilder result;
			if (electricity!=null) {
				result = electricity;
			}
			else {
				result = electricity = ElectricityProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference.AccountReferenceBuilder getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (buyerAccountReference!=null) {
				result = buyerAccountReference;
			}
			else {
				result = buyerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference.AccountReferenceBuilder getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (sellerAccountReference!=null) {
				result = sellerAccountReference;
			}
			else {
				result = sellerAccountReference = AccountReference.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("floatingRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRate")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setFloatingRate(FloatingRate _floatingRate) {
			this.floatingRate = _floatingRate == null ? null : _floatingRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setFixedRate(Schedule _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRate")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setExchangeRate(GenericProductExchangeRate _exchangeRate) {
			this.exchangeRate = _exchangeRate == null ? null : _exchangeRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAsset")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setUnderlyingAsset(Asset _underlyingAsset) {
			this.underlyingAsset = _underlyingAsset == null ? null : _underlyingAsset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceEntity")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setReferenceEntity(LegalEntity _referenceEntity) {
			this.referenceEntity = _referenceEntity == null ? null : _referenceEntity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexReferenceInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexReferenceInformation")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setIndexReferenceInformation(IndexReferenceInformation _indexReferenceInformation) {
			this.indexReferenceInformation = _indexReferenceInformation == null ? null : _indexReferenceInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("gas")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("gas")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setGas(GasProduct _gas) {
			this.gas = _gas == null ? null : _gas.toBuilder();
			return this;
		}
		
		@RosettaAttribute("oil")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("oil")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setOil(OilProduct _oil) {
			this.oil = _oil == null ? null : _oil.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("coal")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setCoal(CoalProduct _coal) {
			this.coal = _coal == null ? null : _coal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("electricity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("electricity")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setElectricity(ElectricityProduct _electricity) {
			this.electricity = _electricity == null ? null : _electricity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingMethod")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setAveragingMethod(AveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerPartyReference")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerPartyReference")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerPartyReference")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public TradeUnderlyer2 build() {
			return new TradeUnderlyer2.TradeUnderlyer2Impl(this);
		}
		
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder prune() {
			if (floatingRate!=null && !floatingRate.prune().hasData()) floatingRate = null;
			if (fixedRate!=null && !fixedRate.prune().hasData()) fixedRate = null;
			if (exchangeRate!=null && !exchangeRate.prune().hasData()) exchangeRate = null;
			if (underlyingAsset!=null && !underlyingAsset.prune().hasData()) underlyingAsset = null;
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (referenceEntity!=null && !referenceEntity.prune().hasData()) referenceEntity = null;
			if (indexReferenceInformation!=null && !indexReferenceInformation.prune().hasData()) indexReferenceInformation = null;
			if (gas!=null && !gas.prune().hasData()) gas = null;
			if (oil!=null && !oil.prune().hasData()) oil = null;
			if (coal!=null && !coal.prune().hasData()) coal = null;
			if (electricity!=null && !electricity.prune().hasData()) electricity = null;
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getFloatingRate()!=null && getFloatingRate().hasData()) return true;
			if (getFixedRate()!=null && getFixedRate().hasData()) return true;
			if (getExchangeRate()!=null && getExchangeRate().hasData()) return true;
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getReferenceEntity()!=null && getReferenceEntity().hasData()) return true;
			if (getIndexReferenceInformation()!=null && getIndexReferenceInformation().hasData()) return true;
			if (getGas()!=null && getGas().hasData()) return true;
			if (getOil()!=null && getOil().hasData()) return true;
			if (getCoal()!=null && getCoal().hasData()) return true;
			if (getElectricity()!=null && getElectricity().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeUnderlyer2.TradeUnderlyer2Builder o = (TradeUnderlyer2.TradeUnderlyer2Builder) other;
			
			merger.mergeRosetta(getFloatingRate(), o.getFloatingRate(), this::setFloatingRate);
			merger.mergeRosetta(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			merger.mergeRosetta(getExchangeRate(), o.getExchangeRate(), this::setExchangeRate);
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::setUnderlyingAsset);
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getReferenceEntity(), o.getReferenceEntity(), this::setReferenceEntity);
			merger.mergeRosetta(getIndexReferenceInformation(), o.getIndexReferenceInformation(), this::setIndexReferenceInformation);
			merger.mergeRosetta(getGas(), o.getGas(), this::setGas);
			merger.mergeRosetta(getOil(), o.getOil(), this::setOil);
			merger.mergeRosetta(getCoal(), o.getCoal(), this::setCoal);
			merger.mergeRosetta(getElectricity(), o.getElectricity(), this::setElectricity);
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeUnderlyer2 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(floatingRate, _that.getFloatingRate())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(exchangeRate, _that.getExchangeRate())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(indexReferenceInformation, _that.getIndexReferenceInformation())) return false;
			if (!Objects.equals(gas, _that.getGas())) return false;
			if (!Objects.equals(oil, _that.getOil())) return false;
			if (!Objects.equals(coal, _that.getCoal())) return false;
			if (!Objects.equals(electricity, _that.getElectricity())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (floatingRate != null ? floatingRate.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformation != null ? indexReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (gas != null ? gas.hashCode() : 0);
			_result = 31 * _result + (oil != null ? oil.hashCode() : 0);
			_result = 31 * _result + (coal != null ? coal.hashCode() : 0);
			_result = 31 * _result + (electricity != null ? electricity.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeUnderlyer2Builder {" +
				"id=" + this.id + ", " +
				"floatingRate=" + this.floatingRate + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"exchangeRate=" + this.exchangeRate + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"referenceEntity=" + this.referenceEntity + ", " +
				"indexReferenceInformation=" + this.indexReferenceInformation + ", " +
				"gas=" + this.gas + ", " +
				"oil=" + this.oil + ", " +
				"coal=" + this.coal + ", " +
				"electricity=" + this.electricity + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}';
		}
	}
}
