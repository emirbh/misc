package fpml.consolidated.loan;

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
import fpml.consolidated.asset.Lien;
import fpml.consolidated.loan.meta.LetterOfCreditFacilityMeta;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.GoverningLaw;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A facility designed to issue letter of credit products.
 *
 */
@RosettaDataType(value="LetterOfCreditFacility", builder=LetterOfCreditFacility.LetterOfCreditFacilityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LetterOfCreditFacility", model="fpml", builder=LetterOfCreditFacility.LetterOfCreditFacilityBuilderImpl.class, version="2.1.1")
public interface LetterOfCreditFacility extends AbstractFacility {

	LetterOfCreditFacilityMeta metaData = new LetterOfCreditFacilityMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	LetterOfCreditFacility build();
	
	LetterOfCreditFacility.LetterOfCreditFacilityBuilder toBuilder();
	
	static LetterOfCreditFacility.LetterOfCreditFacilityBuilder builder() {
		return new LetterOfCreditFacility.LetterOfCreditFacilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LetterOfCreditFacility> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LetterOfCreditFacility> getType() {
		return LetterOfCreditFacility.class;
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
	interface LetterOfCreditFacilityBuilder extends LetterOfCreditFacility, AbstractFacility.AbstractFacilityBuilder {
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setId(String id);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setPartyReference(PartyReference partyReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setDescription(String description);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setDealReference(DealReference dealReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference, int idx);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference, int idx);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference, int idx);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setStartDate(ZonedDateTime startDate);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setExpiryDate(ZonedDateTime expiryDate);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setMaturityDate(ZonedDateTime maturityDate);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setCurrentCommitment(FacilityCommitment currentCommitment);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setOriginalCommitment(MoneyWithParticipantShare originalCommitment);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setCommitmentSchedule(CommitmentSchedule commitmentSchedule);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setDealFxRate(FxTerms dealFxRate);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setGoverningLaw(GoverningLaw governingLaw);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addFeature(FacilityFeature feature);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addFeature(FacilityFeature feature, int idx);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addFeature(List<? extends FacilityFeature> feature);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setFeature(List<? extends FacilityFeature> feature);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setLien(Lien lien);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setSeniority(CreditSeniority seniority);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addAbstractFacilityChoice(AbstractFacilityChoice abstractFacilityChoice);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addAbstractFacilityChoice(AbstractFacilityChoice abstractFacilityChoice, int idx);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoice);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoice);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setAccruingPikOption(AccruingPikOption accruingPikOption);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption, int idx);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder addAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOption);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOption);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setDefaultRate(PeriodRate defaultRate);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setMandatoryCostRate(PeriodRate mandatoryCostRate);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setPenaltyRate(PeriodRate penaltyRate);
		@Override
		LetterOfCreditFacility.LetterOfCreditFacilityBuilder setMultiCurrency(MultiCurrency multiCurrency);

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
		

		LetterOfCreditFacility.LetterOfCreditFacilityBuilder prune();
	}

	/*********************** Immutable Implementation of LetterOfCreditFacility  ***********************/
	class LetterOfCreditFacilityImpl extends AbstractFacility.AbstractFacilityImpl implements LetterOfCreditFacility {
		
		protected LetterOfCreditFacilityImpl(LetterOfCreditFacility.LetterOfCreditFacilityBuilder builder) {
			super(builder);
		}
		
		@Override
		public LetterOfCreditFacility build() {
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder toBuilder() {
			LetterOfCreditFacility.LetterOfCreditFacilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LetterOfCreditFacility.LetterOfCreditFacilityBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditFacility {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LetterOfCreditFacility  ***********************/
	class LetterOfCreditFacilityBuilderImpl extends AbstractFacility.AbstractFacilityBuilderImpl implements LetterOfCreditFacility.LetterOfCreditFacilityBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coBorrowerPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("coBorrowerPartyReference")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addCoBorrowerPartyReference(PartyReference _coBorrowerPartyReference) {
			if (_coBorrowerPartyReference != null) {
				this.coBorrowerPartyReference.add(_coBorrowerPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addCoBorrowerPartyReference(PartyReference _coBorrowerPartyReference, int idx) {
			getIndex(this.coBorrowerPartyReference, idx, () -> _coBorrowerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcIssuingBankPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("lcIssuingBankPartyReference")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addLcIssuingBankPartyReference(PartyReference _lcIssuingBankPartyReference) {
			if (_lcIssuingBankPartyReference != null) {
				this.lcIssuingBankPartyReference.add(_lcIssuingBankPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addLcIssuingBankPartyReference(PartyReference _lcIssuingBankPartyReference, int idx) {
			getIndex(this.lcIssuingBankPartyReference, idx, () -> _lcIssuingBankPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference) {
			if (_guarantorPartyReference != null) {
				this.guarantorPartyReference.add(_guarantorPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference, int idx) {
			getIndex(this.guarantorPartyReference, idx, () -> _guarantorPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDate")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setMaturityDate(ZonedDateTime _maturityDate) {
			this.maturityDate = _maturityDate == null ? null : _maturityDate;
			return this;
		}
		
		@RosettaAttribute("currentCommitment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currentCommitment")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setCurrentCommitment(FacilityCommitment _currentCommitment) {
			this.currentCommitment = _currentCommitment == null ? null : _currentCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originalCommitment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalCommitment")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setOriginalCommitment(MoneyWithParticipantShare _originalCommitment) {
			this.originalCommitment = _originalCommitment == null ? null : _originalCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commitmentSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commitmentSchedule")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setCommitmentSchedule(CommitmentSchedule _commitmentSchedule) {
			this.commitmentSchedule = _commitmentSchedule == null ? null : _commitmentSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealFxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealFxRate")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setDealFxRate(FxTerms _dealFxRate) {
			this.dealFxRate = _dealFxRate == null ? null : _dealFxRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("governingLaw")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("governingLaw")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setGoverningLaw(GoverningLaw _governingLaw) {
			this.governingLaw = _governingLaw == null ? null : _governingLaw.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("feature")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addFeature(FacilityFeature _feature) {
			if (_feature != null) {
				this.feature.add(_feature.toBuilder());
			}
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addFeature(FacilityFeature _feature, int idx) {
			getIndex(this.feature, idx, () -> _feature.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addFeature(List<? extends FacilityFeature> features) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setFeature(List<? extends FacilityFeature> features) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setLien(Lien _lien) {
			this.lien = _lien == null ? null : _lien.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@RosettaAttribute("abstractFacilityChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("abstractFacilityChoice")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addAbstractFacilityChoice(AbstractFacilityChoice _abstractFacilityChoice) {
			if (_abstractFacilityChoice != null) {
				this.abstractFacilityChoice.add(_abstractFacilityChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addAbstractFacilityChoice(AbstractFacilityChoice _abstractFacilityChoice, int idx) {
			getIndex(this.abstractFacilityChoice, idx, () -> _abstractFacilityChoice.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoices) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoices) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setAccruingPikOption(AccruingPikOption _accruingPikOption) {
			this.accruingPikOption = _accruingPikOption == null ? null : _accruingPikOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accruingFeeOption")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addAccruingFeeOption(AccruingFeeOption _accruingFeeOption) {
			if (_accruingFeeOption != null) {
				this.accruingFeeOption.add(_accruingFeeOption.toBuilder());
			}
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addAccruingFeeOption(AccruingFeeOption _accruingFeeOption, int idx) {
			getIndex(this.accruingFeeOption, idx, () -> _accruingFeeOption.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder addAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOptions) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOptions) {
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
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setDefaultRate(PeriodRate _defaultRate) {
			this.defaultRate = _defaultRate == null ? null : _defaultRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mandatoryCostRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryCostRate")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setMandatoryCostRate(PeriodRate _mandatoryCostRate) {
			this.mandatoryCostRate = _mandatoryCostRate == null ? null : _mandatoryCostRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("penaltyRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("penaltyRate")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setPenaltyRate(PeriodRate _penaltyRate) {
			this.penaltyRate = _penaltyRate == null ? null : _penaltyRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multiCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiCurrency")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder setMultiCurrency(MultiCurrency _multiCurrency) {
			this.multiCurrency = _multiCurrency == null ? null : _multiCurrency.toBuilder();
			return this;
		}
		
		@Override
		public LetterOfCreditFacility build() {
			return new LetterOfCreditFacility.LetterOfCreditFacilityImpl(this);
		}
		
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditFacility.LetterOfCreditFacilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LetterOfCreditFacility.LetterOfCreditFacilityBuilder o = (LetterOfCreditFacility.LetterOfCreditFacilityBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditFacilityBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
