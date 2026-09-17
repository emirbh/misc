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
import fpml.consolidated.asset.Lien;
import fpml.consolidated.loan.meta.AbstractFacilityMeta;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.GoverningLaw;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
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
 * version "confirmation-5.13"
 *
 * Provision An abstract type defining a facility baseline structure.
 *
 */
@RosettaDataType(value="AbstractFacility", builder=AbstractFacility.AbstractFacilityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractFacility", model="fpml", builder=AbstractFacility.AbstractFacilityBuilderImpl.class, version="2.1.1")
public interface AbstractFacility extends FacilitySummary {

	AbstractFacilityMeta metaData = new AbstractFacilityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the governing law (jurisdiction) under which the facility operates.
	 *
	 */
	GoverningLaw getGoverningLaw();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Facility features which help define the instrument with greater granularity. E.g. bridge, acquisition etc.
	 *
	 */
	List<? extends FacilityFeature> getFeature();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The lien level associated with the facility. E.g. 1st, 2nd, 3rd.
	 *
	 */
	Lien getLien();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The seniority of the facility. E.g. senior, senior secured etc.
	 *
	 */
	CreditSeniority getSeniority();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends AbstractFacilityChoice> getAbstractFacilityChoice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A loan contract PIK accrual option.
	 *
	 */
	AccruingPikOption getAccruingPikOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A description of all the different types of accruing fees which apply to the facility.
	 *
	 */
	List<? extends AccruingFeeOption> getAccruingFeeOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This represents a default rate that may apply in addition to a regular margin rate (on outstanding loan contracts). This rate is applied at the discretion of the agent bank, if the borrower is deemed to be in default.
	 *
	 */
	PeriodRate getDefaultRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The mandatory cost rate currently applied to the interest rate period.
	 *
	 */
	PeriodRate getMandatoryCostRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This represents a penalty rate that may apply in addition to the regular margin rate (on outstanding loan contracts). This rate is applied at the discretion of the agent bank, if the borrower has broken terms stated within the credit agreement.
	 *
	 */
	PeriodRate getPenaltyRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A container to denote whether funds may be drawn in multiple currency denominations, in addition to the base (facility) currency. The current commitment amount defines the base currency associated with the facility.
	 *
	 */
	MultiCurrency getMultiCurrency();

	/*********************** Build Methods  ***********************/
	AbstractFacility build();
	
	AbstractFacility.AbstractFacilityBuilder toBuilder();
	
	static AbstractFacility.AbstractFacilityBuilder builder() {
		return new AbstractFacility.AbstractFacilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractFacility> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractFacility> getType() {
		return AbstractFacility.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("dealReference"), processor, DealReference.class, getDealReference());
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processRosetta(path.newSubPath("coBorrowerPartyReference"), processor, PartyReference.class, getCoBorrowerPartyReference());
		processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.class, getAgentPartyReference());
		processRosetta(path.newSubPath("lcIssuingBankPartyReference"), processor, PartyReference.class, getLcIssuingBankPartyReference());
		processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.class, getGuarantorPartyReference());
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
		processRosetta(path.newSubPath("currentCommitment"), processor, FacilityCommitment.class, getCurrentCommitment());
		processRosetta(path.newSubPath("originalCommitment"), processor, MoneyWithParticipantShare.class, getOriginalCommitment());
		processRosetta(path.newSubPath("commitmentSchedule"), processor, CommitmentSchedule.class, getCommitmentSchedule());
		processRosetta(path.newSubPath("dealFxRate"), processor, FxTerms.class, getDealFxRate());
		processRosetta(path.newSubPath("governingLaw"), processor, GoverningLaw.class, getGoverningLaw());
		processRosetta(path.newSubPath("feature"), processor, FacilityFeature.class, getFeature());
		processRosetta(path.newSubPath("lien"), processor, Lien.class, getLien());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
		processRosetta(path.newSubPath("abstractFacilityChoice"), processor, AbstractFacilityChoice.class, getAbstractFacilityChoice());
		processRosetta(path.newSubPath("accruingPikOption"), processor, AccruingPikOption.class, getAccruingPikOption());
		processRosetta(path.newSubPath("accruingFeeOption"), processor, AccruingFeeOption.class, getAccruingFeeOption());
		processRosetta(path.newSubPath("defaultRate"), processor, PeriodRate.class, getDefaultRate());
		processRosetta(path.newSubPath("mandatoryCostRate"), processor, PeriodRate.class, getMandatoryCostRate());
		processRosetta(path.newSubPath("penaltyRate"), processor, PeriodRate.class, getPenaltyRate());
		processRosetta(path.newSubPath("multiCurrency"), processor, MultiCurrency.class, getMultiCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractFacilityBuilder extends AbstractFacility, FacilitySummary.FacilitySummaryBuilder {
		GoverningLaw.GoverningLawBuilder getOrCreateGoverningLaw();
		@Override
		GoverningLaw.GoverningLawBuilder getGoverningLaw();
		FacilityFeature.FacilityFeatureBuilder getOrCreateFeature(int index);
		@Override
		List<? extends FacilityFeature.FacilityFeatureBuilder> getFeature();
		Lien.LienBuilder getOrCreateLien();
		@Override
		Lien.LienBuilder getLien();
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		@Override
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		AbstractFacilityChoice.AbstractFacilityChoiceBuilder getOrCreateAbstractFacilityChoice(int index);
		@Override
		List<? extends AbstractFacilityChoice.AbstractFacilityChoiceBuilder> getAbstractFacilityChoice();
		AccruingPikOption.AccruingPikOptionBuilder getOrCreateAccruingPikOption();
		@Override
		AccruingPikOption.AccruingPikOptionBuilder getAccruingPikOption();
		AccruingFeeOption.AccruingFeeOptionBuilder getOrCreateAccruingFeeOption(int index);
		@Override
		List<? extends AccruingFeeOption.AccruingFeeOptionBuilder> getAccruingFeeOption();
		PeriodRate.PeriodRateBuilder getOrCreateDefaultRate();
		@Override
		PeriodRate.PeriodRateBuilder getDefaultRate();
		PeriodRate.PeriodRateBuilder getOrCreateMandatoryCostRate();
		@Override
		PeriodRate.PeriodRateBuilder getMandatoryCostRate();
		PeriodRate.PeriodRateBuilder getOrCreatePenaltyRate();
		@Override
		PeriodRate.PeriodRateBuilder getPenaltyRate();
		MultiCurrency.MultiCurrencyBuilder getOrCreateMultiCurrency();
		@Override
		MultiCurrency.MultiCurrencyBuilder getMultiCurrency();
		@Override
		AbstractFacility.AbstractFacilityBuilder setId(String id);
		@Override
		AbstractFacility.AbstractFacilityBuilder setPartyReference(PartyReference partyReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		AbstractFacility.AbstractFacilityBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		AbstractFacility.AbstractFacilityBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		AbstractFacility.AbstractFacilityBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		AbstractFacility.AbstractFacilityBuilder setDescription(String description);
		@Override
		AbstractFacility.AbstractFacilityBuilder setDealReference(DealReference dealReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference, int idx);
		@Override
		AbstractFacility.AbstractFacilityBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference, int idx);
		@Override
		AbstractFacility.AbstractFacilityBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference, int idx);
		@Override
		AbstractFacility.AbstractFacilityBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		@Override
		AbstractFacility.AbstractFacilityBuilder setStartDate(ZonedDateTime startDate);
		@Override
		AbstractFacility.AbstractFacilityBuilder setExpiryDate(ZonedDateTime expiryDate);
		@Override
		AbstractFacility.AbstractFacilityBuilder setMaturityDate(ZonedDateTime maturityDate);
		@Override
		AbstractFacility.AbstractFacilityBuilder setCurrentCommitment(FacilityCommitment currentCommitment);
		@Override
		AbstractFacility.AbstractFacilityBuilder setOriginalCommitment(MoneyWithParticipantShare originalCommitment);
		@Override
		AbstractFacility.AbstractFacilityBuilder setCommitmentSchedule(CommitmentSchedule commitmentSchedule);
		@Override
		AbstractFacility.AbstractFacilityBuilder setDealFxRate(FxTerms dealFxRate);
		AbstractFacility.AbstractFacilityBuilder setGoverningLaw(GoverningLaw governingLaw);
		AbstractFacility.AbstractFacilityBuilder addFeature(FacilityFeature feature);
		AbstractFacility.AbstractFacilityBuilder addFeature(FacilityFeature feature, int idx);
		AbstractFacility.AbstractFacilityBuilder addFeature(List<? extends FacilityFeature> feature);
		AbstractFacility.AbstractFacilityBuilder setFeature(List<? extends FacilityFeature> feature);
		AbstractFacility.AbstractFacilityBuilder setLien(Lien lien);
		AbstractFacility.AbstractFacilityBuilder setSeniority(CreditSeniority seniority);
		AbstractFacility.AbstractFacilityBuilder addAbstractFacilityChoice(AbstractFacilityChoice abstractFacilityChoice);
		AbstractFacility.AbstractFacilityBuilder addAbstractFacilityChoice(AbstractFacilityChoice abstractFacilityChoice, int idx);
		AbstractFacility.AbstractFacilityBuilder addAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoice);
		AbstractFacility.AbstractFacilityBuilder setAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoice);
		AbstractFacility.AbstractFacilityBuilder setAccruingPikOption(AccruingPikOption accruingPikOption);
		AbstractFacility.AbstractFacilityBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption);
		AbstractFacility.AbstractFacilityBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption, int idx);
		AbstractFacility.AbstractFacilityBuilder addAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOption);
		AbstractFacility.AbstractFacilityBuilder setAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOption);
		AbstractFacility.AbstractFacilityBuilder setDefaultRate(PeriodRate defaultRate);
		AbstractFacility.AbstractFacilityBuilder setMandatoryCostRate(PeriodRate mandatoryCostRate);
		AbstractFacility.AbstractFacilityBuilder setPenaltyRate(PeriodRate penaltyRate);
		AbstractFacility.AbstractFacilityBuilder setMultiCurrency(MultiCurrency multiCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("dealReference"), processor, DealReference.DealReferenceBuilder.class, getDealReference());
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processRosetta(path.newSubPath("coBorrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCoBorrowerPartyReference());
			processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAgentPartyReference());
			processRosetta(path.newSubPath("lcIssuingBankPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLcIssuingBankPartyReference());
			processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getGuarantorPartyReference());
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
			processRosetta(path.newSubPath("currentCommitment"), processor, FacilityCommitment.FacilityCommitmentBuilder.class, getCurrentCommitment());
			processRosetta(path.newSubPath("originalCommitment"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getOriginalCommitment());
			processRosetta(path.newSubPath("commitmentSchedule"), processor, CommitmentSchedule.CommitmentScheduleBuilder.class, getCommitmentSchedule());
			processRosetta(path.newSubPath("dealFxRate"), processor, FxTerms.FxTermsBuilder.class, getDealFxRate());
			processRosetta(path.newSubPath("governingLaw"), processor, GoverningLaw.GoverningLawBuilder.class, getGoverningLaw());
			processRosetta(path.newSubPath("feature"), processor, FacilityFeature.FacilityFeatureBuilder.class, getFeature());
			processRosetta(path.newSubPath("lien"), processor, Lien.LienBuilder.class, getLien());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
			processRosetta(path.newSubPath("abstractFacilityChoice"), processor, AbstractFacilityChoice.AbstractFacilityChoiceBuilder.class, getAbstractFacilityChoice());
			processRosetta(path.newSubPath("accruingPikOption"), processor, AccruingPikOption.AccruingPikOptionBuilder.class, getAccruingPikOption());
			processRosetta(path.newSubPath("accruingFeeOption"), processor, AccruingFeeOption.AccruingFeeOptionBuilder.class, getAccruingFeeOption());
			processRosetta(path.newSubPath("defaultRate"), processor, PeriodRate.PeriodRateBuilder.class, getDefaultRate());
			processRosetta(path.newSubPath("mandatoryCostRate"), processor, PeriodRate.PeriodRateBuilder.class, getMandatoryCostRate());
			processRosetta(path.newSubPath("penaltyRate"), processor, PeriodRate.PeriodRateBuilder.class, getPenaltyRate());
			processRosetta(path.newSubPath("multiCurrency"), processor, MultiCurrency.MultiCurrencyBuilder.class, getMultiCurrency());
		}
		

		AbstractFacility.AbstractFacilityBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractFacility  ***********************/
	class AbstractFacilityImpl extends FacilitySummary.FacilitySummaryImpl implements AbstractFacility {
		private final GoverningLaw governingLaw;
		private final List<? extends FacilityFeature> feature;
		private final Lien lien;
		private final CreditSeniority seniority;
		private final List<? extends AbstractFacilityChoice> abstractFacilityChoice;
		private final AccruingPikOption accruingPikOption;
		private final List<? extends AccruingFeeOption> accruingFeeOption;
		private final PeriodRate defaultRate;
		private final PeriodRate mandatoryCostRate;
		private final PeriodRate penaltyRate;
		private final MultiCurrency multiCurrency;
		
		protected AbstractFacilityImpl(AbstractFacility.AbstractFacilityBuilder builder) {
			super(builder);
			this.governingLaw = ofNullable(builder.getGoverningLaw()).map(f->f.build()).orElse(null);
			this.feature = ofNullable(builder.getFeature()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.lien = ofNullable(builder.getLien()).map(f->f.build()).orElse(null);
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
			this.abstractFacilityChoice = ofNullable(builder.getAbstractFacilityChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.accruingPikOption = ofNullable(builder.getAccruingPikOption()).map(f->f.build()).orElse(null);
			this.accruingFeeOption = ofNullable(builder.getAccruingFeeOption()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.defaultRate = ofNullable(builder.getDefaultRate()).map(f->f.build()).orElse(null);
			this.mandatoryCostRate = ofNullable(builder.getMandatoryCostRate()).map(f->f.build()).orElse(null);
			this.penaltyRate = ofNullable(builder.getPenaltyRate()).map(f->f.build()).orElse(null);
			this.multiCurrency = ofNullable(builder.getMultiCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("governingLaw")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("governingLaw")
		public GoverningLaw getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		@RosettaAttribute("feature")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("feature")
		public List<? extends FacilityFeature> getFeature() {
			return feature;
		}
		
		@Override
		@RosettaAttribute("lien")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lien")
		public Lien getLien() {
			return lien;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		@RosettaAttribute("abstractFacilityChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("abstractFacilityChoice")
		public List<? extends AbstractFacilityChoice> getAbstractFacilityChoice() {
			return abstractFacilityChoice;
		}
		
		@Override
		@RosettaAttribute("accruingPikOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruingPikOption")
		public AccruingPikOption getAccruingPikOption() {
			return accruingPikOption;
		}
		
		@Override
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("accruingFeeOption")
		public List<? extends AccruingFeeOption> getAccruingFeeOption() {
			return accruingFeeOption;
		}
		
		@Override
		@RosettaAttribute("defaultRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("defaultRate")
		public PeriodRate getDefaultRate() {
			return defaultRate;
		}
		
		@Override
		@RosettaAttribute("mandatoryCostRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryCostRate")
		public PeriodRate getMandatoryCostRate() {
			return mandatoryCostRate;
		}
		
		@Override
		@RosettaAttribute("penaltyRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("penaltyRate")
		public PeriodRate getPenaltyRate() {
			return penaltyRate;
		}
		
		@Override
		@RosettaAttribute("multiCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiCurrency")
		public MultiCurrency getMultiCurrency() {
			return multiCurrency;
		}
		
		@Override
		public AbstractFacility build() {
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder toBuilder() {
			AbstractFacility.AbstractFacilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractFacility.AbstractFacilityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getGoverningLaw()).ifPresent(builder::setGoverningLaw);
			ofNullable(getFeature()).ifPresent(builder::setFeature);
			ofNullable(getLien()).ifPresent(builder::setLien);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
			ofNullable(getAbstractFacilityChoice()).ifPresent(builder::setAbstractFacilityChoice);
			ofNullable(getAccruingPikOption()).ifPresent(builder::setAccruingPikOption);
			ofNullable(getAccruingFeeOption()).ifPresent(builder::setAccruingFeeOption);
			ofNullable(getDefaultRate()).ifPresent(builder::setDefaultRate);
			ofNullable(getMandatoryCostRate()).ifPresent(builder::setMandatoryCostRate);
			ofNullable(getPenaltyRate()).ifPresent(builder::setPenaltyRate);
			ofNullable(getMultiCurrency()).ifPresent(builder::setMultiCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacility _that = getType().cast(o);
		
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!ListEquals.listEquals(feature, _that.getFeature())) return false;
			if (!Objects.equals(lien, _that.getLien())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!ListEquals.listEquals(abstractFacilityChoice, _that.getAbstractFacilityChoice())) return false;
			if (!Objects.equals(accruingPikOption, _that.getAccruingPikOption())) return false;
			if (!ListEquals.listEquals(accruingFeeOption, _that.getAccruingFeeOption())) return false;
			if (!Objects.equals(defaultRate, _that.getDefaultRate())) return false;
			if (!Objects.equals(mandatoryCostRate, _that.getMandatoryCostRate())) return false;
			if (!Objects.equals(penaltyRate, _that.getPenaltyRate())) return false;
			if (!Objects.equals(multiCurrency, _that.getMultiCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (governingLaw != null ? governingLaw.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (lien != null ? lien.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (abstractFacilityChoice != null ? abstractFacilityChoice.hashCode() : 0);
			_result = 31 * _result + (accruingPikOption != null ? accruingPikOption.hashCode() : 0);
			_result = 31 * _result + (accruingFeeOption != null ? accruingFeeOption.hashCode() : 0);
			_result = 31 * _result + (defaultRate != null ? defaultRate.hashCode() : 0);
			_result = 31 * _result + (mandatoryCostRate != null ? mandatoryCostRate.hashCode() : 0);
			_result = 31 * _result + (penaltyRate != null ? penaltyRate.hashCode() : 0);
			_result = 31 * _result + (multiCurrency != null ? multiCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacility {" +
				"governingLaw=" + this.governingLaw + ", " +
				"feature=" + this.feature + ", " +
				"lien=" + this.lien + ", " +
				"seniority=" + this.seniority + ", " +
				"abstractFacilityChoice=" + this.abstractFacilityChoice + ", " +
				"accruingPikOption=" + this.accruingPikOption + ", " +
				"accruingFeeOption=" + this.accruingFeeOption + ", " +
				"defaultRate=" + this.defaultRate + ", " +
				"mandatoryCostRate=" + this.mandatoryCostRate + ", " +
				"penaltyRate=" + this.penaltyRate + ", " +
				"multiCurrency=" + this.multiCurrency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractFacility  ***********************/
	class AbstractFacilityBuilderImpl extends FacilitySummary.FacilitySummaryBuilderImpl implements AbstractFacility.AbstractFacilityBuilder {
	
		protected GoverningLaw.GoverningLawBuilder governingLaw;
		protected List<FacilityFeature.FacilityFeatureBuilder> feature = new ArrayList<>();
		protected Lien.LienBuilder lien;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
		protected List<AbstractFacilityChoice.AbstractFacilityChoiceBuilder> abstractFacilityChoice = new ArrayList<>();
		protected AccruingPikOption.AccruingPikOptionBuilder accruingPikOption;
		protected List<AccruingFeeOption.AccruingFeeOptionBuilder> accruingFeeOption = new ArrayList<>();
		protected PeriodRate.PeriodRateBuilder defaultRate;
		protected PeriodRate.PeriodRateBuilder mandatoryCostRate;
		protected PeriodRate.PeriodRateBuilder penaltyRate;
		protected MultiCurrency.MultiCurrencyBuilder multiCurrency;
		
		@Override
		@RosettaAttribute("governingLaw")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("governingLaw")
		public GoverningLaw.GoverningLawBuilder getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		public GoverningLaw.GoverningLawBuilder getOrCreateGoverningLaw() {
			GoverningLaw.GoverningLawBuilder result;
			if (governingLaw!=null) {
				result = governingLaw;
			}
			else {
				result = governingLaw = GoverningLaw.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feature")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("feature")
		public List<? extends FacilityFeature.FacilityFeatureBuilder> getFeature() {
			return feature;
		}
		
		@Override
		public FacilityFeature.FacilityFeatureBuilder getOrCreateFeature(int index) {
			if (feature==null) {
				this.feature = new ArrayList<>();
			}
			return getIndex(feature, index, () -> {
						FacilityFeature.FacilityFeatureBuilder newFeature = FacilityFeature.builder();
						return newFeature;
					});
		}
		
		@Override
		@RosettaAttribute("lien")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lien")
		public Lien.LienBuilder getLien() {
			return lien;
		}
		
		@Override
		public Lien.LienBuilder getOrCreateLien() {
			Lien.LienBuilder result;
			if (lien!=null) {
				result = lien;
			}
			else {
				result = lien = Lien.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority.CreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority() {
			CreditSeniority.CreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = CreditSeniority.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("abstractFacilityChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("abstractFacilityChoice")
		public List<? extends AbstractFacilityChoice.AbstractFacilityChoiceBuilder> getAbstractFacilityChoice() {
			return abstractFacilityChoice;
		}
		
		@Override
		public AbstractFacilityChoice.AbstractFacilityChoiceBuilder getOrCreateAbstractFacilityChoice(int index) {
			if (abstractFacilityChoice==null) {
				this.abstractFacilityChoice = new ArrayList<>();
			}
			return getIndex(abstractFacilityChoice, index, () -> {
						AbstractFacilityChoice.AbstractFacilityChoiceBuilder newAbstractFacilityChoice = AbstractFacilityChoice.builder();
						return newAbstractFacilityChoice;
					});
		}
		
		@Override
		@RosettaAttribute("accruingPikOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruingPikOption")
		public AccruingPikOption.AccruingPikOptionBuilder getAccruingPikOption() {
			return accruingPikOption;
		}
		
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder getOrCreateAccruingPikOption() {
			AccruingPikOption.AccruingPikOptionBuilder result;
			if (accruingPikOption!=null) {
				result = accruingPikOption;
			}
			else {
				result = accruingPikOption = AccruingPikOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("accruingFeeOption")
		public List<? extends AccruingFeeOption.AccruingFeeOptionBuilder> getAccruingFeeOption() {
			return accruingFeeOption;
		}
		
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder getOrCreateAccruingFeeOption(int index) {
			if (accruingFeeOption==null) {
				this.accruingFeeOption = new ArrayList<>();
			}
			return getIndex(accruingFeeOption, index, () -> {
						AccruingFeeOption.AccruingFeeOptionBuilder newAccruingFeeOption = AccruingFeeOption.builder();
						return newAccruingFeeOption;
					});
		}
		
		@Override
		@RosettaAttribute("defaultRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("defaultRate")
		public PeriodRate.PeriodRateBuilder getDefaultRate() {
			return defaultRate;
		}
		
		@Override
		public PeriodRate.PeriodRateBuilder getOrCreateDefaultRate() {
			PeriodRate.PeriodRateBuilder result;
			if (defaultRate!=null) {
				result = defaultRate;
			}
			else {
				result = defaultRate = PeriodRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatoryCostRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryCostRate")
		public PeriodRate.PeriodRateBuilder getMandatoryCostRate() {
			return mandatoryCostRate;
		}
		
		@Override
		public PeriodRate.PeriodRateBuilder getOrCreateMandatoryCostRate() {
			PeriodRate.PeriodRateBuilder result;
			if (mandatoryCostRate!=null) {
				result = mandatoryCostRate;
			}
			else {
				result = mandatoryCostRate = PeriodRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("penaltyRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("penaltyRate")
		public PeriodRate.PeriodRateBuilder getPenaltyRate() {
			return penaltyRate;
		}
		
		@Override
		public PeriodRate.PeriodRateBuilder getOrCreatePenaltyRate() {
			PeriodRate.PeriodRateBuilder result;
			if (penaltyRate!=null) {
				result = penaltyRate;
			}
			else {
				result = penaltyRate = PeriodRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multiCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiCurrency")
		public MultiCurrency.MultiCurrencyBuilder getMultiCurrency() {
			return multiCurrency;
		}
		
		@Override
		public MultiCurrency.MultiCurrencyBuilder getOrCreateMultiCurrency() {
			MultiCurrency.MultiCurrencyBuilder result;
			if (multiCurrency!=null) {
				result = multiCurrency;
			}
			else {
				result = multiCurrency = MultiCurrency.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public AbstractFacility.AbstractFacilityBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coBorrowerPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("coBorrowerPartyReference")
		@Override
		public AbstractFacility.AbstractFacilityBuilder addCoBorrowerPartyReference(PartyReference _coBorrowerPartyReference) {
			if (_coBorrowerPartyReference != null) {
				this.coBorrowerPartyReference.add(_coBorrowerPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addCoBorrowerPartyReference(PartyReference _coBorrowerPartyReference, int idx) {
			getIndex(this.coBorrowerPartyReference, idx, () -> _coBorrowerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
			if (coBorrowerPartyReferences != null) {
				for (final PartyReference toAdd : coBorrowerPartyReferences) {
					this.coBorrowerPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("coBorrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("coBorrowerPartyReference")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
			if (coBorrowerPartyReferences == null) {
				this.coBorrowerPartyReference = new ArrayList<>();
			} else {
				this.coBorrowerPartyReference = coBorrowerPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcIssuingBankPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("lcIssuingBankPartyReference")
		@Override
		public AbstractFacility.AbstractFacilityBuilder addLcIssuingBankPartyReference(PartyReference _lcIssuingBankPartyReference) {
			if (_lcIssuingBankPartyReference != null) {
				this.lcIssuingBankPartyReference.add(_lcIssuingBankPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addLcIssuingBankPartyReference(PartyReference _lcIssuingBankPartyReference, int idx) {
			getIndex(this.lcIssuingBankPartyReference, idx, () -> _lcIssuingBankPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
			if (lcIssuingBankPartyReferences != null) {
				for (final PartyReference toAdd : lcIssuingBankPartyReferences) {
					this.lcIssuingBankPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("lcIssuingBankPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("lcIssuingBankPartyReference")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
			if (lcIssuingBankPartyReferences == null) {
				this.lcIssuingBankPartyReference = new ArrayList<>();
			} else {
				this.lcIssuingBankPartyReference = lcIssuingBankPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		@Override
		public AbstractFacility.AbstractFacilityBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference) {
			if (_guarantorPartyReference != null) {
				this.guarantorPartyReference.add(_guarantorPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference, int idx) {
			getIndex(this.guarantorPartyReference, idx, () -> _guarantorPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
			if (guarantorPartyReferences != null) {
				for (final PartyReference toAdd : guarantorPartyReferences) {
					this.guarantorPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
			if (guarantorPartyReferences == null) {
				this.guarantorPartyReference = new ArrayList<>();
			} else {
				this.guarantorPartyReference = guarantorPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDate")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setMaturityDate(ZonedDateTime _maturityDate) {
			this.maturityDate = _maturityDate == null ? null : _maturityDate;
			return this;
		}
		
		@RosettaAttribute("currentCommitment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currentCommitment")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setCurrentCommitment(FacilityCommitment _currentCommitment) {
			this.currentCommitment = _currentCommitment == null ? null : _currentCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originalCommitment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalCommitment")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setOriginalCommitment(MoneyWithParticipantShare _originalCommitment) {
			this.originalCommitment = _originalCommitment == null ? null : _originalCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commitmentSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commitmentSchedule")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setCommitmentSchedule(CommitmentSchedule _commitmentSchedule) {
			this.commitmentSchedule = _commitmentSchedule == null ? null : _commitmentSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealFxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealFxRate")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setDealFxRate(FxTerms _dealFxRate) {
			this.dealFxRate = _dealFxRate == null ? null : _dealFxRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("governingLaw")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("governingLaw")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setGoverningLaw(GoverningLaw _governingLaw) {
			this.governingLaw = _governingLaw == null ? null : _governingLaw.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("feature")
		@Override
		public AbstractFacility.AbstractFacilityBuilder addFeature(FacilityFeature _feature) {
			if (_feature != null) {
				this.feature.add(_feature.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addFeature(FacilityFeature _feature, int idx) {
			getIndex(this.feature, idx, () -> _feature.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addFeature(List<? extends FacilityFeature> features) {
			if (features != null) {
				for (final FacilityFeature toAdd : features) {
					this.feature.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("feature")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setFeature(List<? extends FacilityFeature> features) {
			if (features == null) {
				this.feature = new ArrayList<>();
			} else {
				this.feature = features.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("lien")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lien")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setLien(Lien _lien) {
			this.lien = _lien == null ? null : _lien.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@RosettaAttribute("abstractFacilityChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("abstractFacilityChoice")
		@Override
		public AbstractFacility.AbstractFacilityBuilder addAbstractFacilityChoice(AbstractFacilityChoice _abstractFacilityChoice) {
			if (_abstractFacilityChoice != null) {
				this.abstractFacilityChoice.add(_abstractFacilityChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addAbstractFacilityChoice(AbstractFacilityChoice _abstractFacilityChoice, int idx) {
			getIndex(this.abstractFacilityChoice, idx, () -> _abstractFacilityChoice.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoices) {
			if (abstractFacilityChoices != null) {
				for (final AbstractFacilityChoice toAdd : abstractFacilityChoices) {
					this.abstractFacilityChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("abstractFacilityChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("abstractFacilityChoice")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoices) {
			if (abstractFacilityChoices == null) {
				this.abstractFacilityChoice = new ArrayList<>();
			} else {
				this.abstractFacilityChoice = abstractFacilityChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("accruingPikOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accruingPikOption")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setAccruingPikOption(AccruingPikOption _accruingPikOption) {
			this.accruingPikOption = _accruingPikOption == null ? null : _accruingPikOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accruingFeeOption")
		@Override
		public AbstractFacility.AbstractFacilityBuilder addAccruingFeeOption(AccruingFeeOption _accruingFeeOption) {
			if (_accruingFeeOption != null) {
				this.accruingFeeOption.add(_accruingFeeOption.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addAccruingFeeOption(AccruingFeeOption _accruingFeeOption, int idx) {
			getIndex(this.accruingFeeOption, idx, () -> _accruingFeeOption.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder addAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOptions) {
			if (accruingFeeOptions != null) {
				for (final AccruingFeeOption toAdd : accruingFeeOptions) {
					this.accruingFeeOption.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("accruingFeeOption")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOptions) {
			if (accruingFeeOptions == null) {
				this.accruingFeeOption = new ArrayList<>();
			} else {
				this.accruingFeeOption = accruingFeeOptions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("defaultRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("defaultRate")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setDefaultRate(PeriodRate _defaultRate) {
			this.defaultRate = _defaultRate == null ? null : _defaultRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mandatoryCostRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryCostRate")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setMandatoryCostRate(PeriodRate _mandatoryCostRate) {
			this.mandatoryCostRate = _mandatoryCostRate == null ? null : _mandatoryCostRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("penaltyRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("penaltyRate")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setPenaltyRate(PeriodRate _penaltyRate) {
			this.penaltyRate = _penaltyRate == null ? null : _penaltyRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multiCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiCurrency")
		@Override
		public AbstractFacility.AbstractFacilityBuilder setMultiCurrency(MultiCurrency _multiCurrency) {
			this.multiCurrency = _multiCurrency == null ? null : _multiCurrency.toBuilder();
			return this;
		}
		
		@Override
		public AbstractFacility build() {
			return new AbstractFacility.AbstractFacilityImpl(this);
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacility.AbstractFacilityBuilder prune() {
			super.prune();
			if (governingLaw!=null && !governingLaw.prune().hasData()) governingLaw = null;
			feature = feature.stream().filter(b->b!=null).<FacilityFeature.FacilityFeatureBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (lien!=null && !lien.prune().hasData()) lien = null;
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			abstractFacilityChoice = abstractFacilityChoice.stream().filter(b->b!=null).<AbstractFacilityChoice.AbstractFacilityChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (accruingPikOption!=null && !accruingPikOption.prune().hasData()) accruingPikOption = null;
			accruingFeeOption = accruingFeeOption.stream().filter(b->b!=null).<AccruingFeeOption.AccruingFeeOptionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (defaultRate!=null && !defaultRate.prune().hasData()) defaultRate = null;
			if (mandatoryCostRate!=null && !mandatoryCostRate.prune().hasData()) mandatoryCostRate = null;
			if (penaltyRate!=null && !penaltyRate.prune().hasData()) penaltyRate = null;
			if (multiCurrency!=null && !multiCurrency.prune().hasData()) multiCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getGoverningLaw()!=null && getGoverningLaw().hasData()) return true;
			if (getFeature()!=null && getFeature().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLien()!=null && getLien().hasData()) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			if (getAbstractFacilityChoice()!=null && getAbstractFacilityChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccruingPikOption()!=null && getAccruingPikOption().hasData()) return true;
			if (getAccruingFeeOption()!=null && getAccruingFeeOption().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDefaultRate()!=null && getDefaultRate().hasData()) return true;
			if (getMandatoryCostRate()!=null && getMandatoryCostRate().hasData()) return true;
			if (getPenaltyRate()!=null && getPenaltyRate().hasData()) return true;
			if (getMultiCurrency()!=null && getMultiCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacility.AbstractFacilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractFacility.AbstractFacilityBuilder o = (AbstractFacility.AbstractFacilityBuilder) other;
			
			merger.mergeRosetta(getGoverningLaw(), o.getGoverningLaw(), this::setGoverningLaw);
			merger.mergeRosetta(getFeature(), o.getFeature(), this::getOrCreateFeature);
			merger.mergeRosetta(getLien(), o.getLien(), this::setLien);
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			merger.mergeRosetta(getAbstractFacilityChoice(), o.getAbstractFacilityChoice(), this::getOrCreateAbstractFacilityChoice);
			merger.mergeRosetta(getAccruingPikOption(), o.getAccruingPikOption(), this::setAccruingPikOption);
			merger.mergeRosetta(getAccruingFeeOption(), o.getAccruingFeeOption(), this::getOrCreateAccruingFeeOption);
			merger.mergeRosetta(getDefaultRate(), o.getDefaultRate(), this::setDefaultRate);
			merger.mergeRosetta(getMandatoryCostRate(), o.getMandatoryCostRate(), this::setMandatoryCostRate);
			merger.mergeRosetta(getPenaltyRate(), o.getPenaltyRate(), this::setPenaltyRate);
			merger.mergeRosetta(getMultiCurrency(), o.getMultiCurrency(), this::setMultiCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacility _that = getType().cast(o);
		
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!ListEquals.listEquals(feature, _that.getFeature())) return false;
			if (!Objects.equals(lien, _that.getLien())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!ListEquals.listEquals(abstractFacilityChoice, _that.getAbstractFacilityChoice())) return false;
			if (!Objects.equals(accruingPikOption, _that.getAccruingPikOption())) return false;
			if (!ListEquals.listEquals(accruingFeeOption, _that.getAccruingFeeOption())) return false;
			if (!Objects.equals(defaultRate, _that.getDefaultRate())) return false;
			if (!Objects.equals(mandatoryCostRate, _that.getMandatoryCostRate())) return false;
			if (!Objects.equals(penaltyRate, _that.getPenaltyRate())) return false;
			if (!Objects.equals(multiCurrency, _that.getMultiCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (governingLaw != null ? governingLaw.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (lien != null ? lien.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (abstractFacilityChoice != null ? abstractFacilityChoice.hashCode() : 0);
			_result = 31 * _result + (accruingPikOption != null ? accruingPikOption.hashCode() : 0);
			_result = 31 * _result + (accruingFeeOption != null ? accruingFeeOption.hashCode() : 0);
			_result = 31 * _result + (defaultRate != null ? defaultRate.hashCode() : 0);
			_result = 31 * _result + (mandatoryCostRate != null ? mandatoryCostRate.hashCode() : 0);
			_result = 31 * _result + (penaltyRate != null ? penaltyRate.hashCode() : 0);
			_result = 31 * _result + (multiCurrency != null ? multiCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityBuilder {" +
				"governingLaw=" + this.governingLaw + ", " +
				"feature=" + this.feature + ", " +
				"lien=" + this.lien + ", " +
				"seniority=" + this.seniority + ", " +
				"abstractFacilityChoice=" + this.abstractFacilityChoice + ", " +
				"accruingPikOption=" + this.accruingPikOption + ", " +
				"accruingFeeOption=" + this.accruingFeeOption + ", " +
				"defaultRate=" + this.defaultRate + ", " +
				"mandatoryCostRate=" + this.mandatoryCostRate + ", " +
				"penaltyRate=" + this.penaltyRate + ", " +
				"multiCurrency=" + this.multiCurrency +
			'}' + " " + super.toString();
		}
	}
}
