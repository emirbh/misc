package fpml.consolidated.eq.shared;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.eq.shared.meta.ExtraordinaryEventsMeta;
import fpml.consolidated.fpmlenum.NationalisationOrInsolvencyOrDelistingEventEnum;
import fpml.consolidated.shared.ExchangeId;
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
 * Provision Where the underlying is shares, defines market events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Where the underlying is shares, defines market events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
 *
 */
@RosettaDataType(value="ExtraordinaryEvents", builder=ExtraordinaryEvents.ExtraordinaryEventsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExtraordinaryEvents", model="fpml", builder=ExtraordinaryEvents.ExtraordinaryEventsBuilderImpl.class, version="2.1.1")
public interface ExtraordinaryEvents extends RosettaModelObject {

	ExtraordinaryEventsMeta metaData = new ExtraordinaryEventsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Occurs when the underlying ceases to exist following a merger between the Issuer and another company.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Occurs when the underlying ceases to exist following a merger between the Issuer and another company.
	 *
	 */
	EquityCorporateEvents getMergerEvents();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. If present and true, then tender offer is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision DEPRECATED. If present and true, then tender offer is applicable.
	 *
	 */
	Boolean getTenderOffer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision ISDA 2002 Equity Tender Offer Events.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision ISDA 2002 Equity Tender Offer Events.
	 *
	 */
	EquityCorporateEvents getTenderOfferEvents();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true, then composition of combined consideration is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true, then composition of combined consideration is applicable.
	 *
	 */
	Boolean getCompositionOfCombinedConsideration();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision ISDA 2002 Equity Index Adjustment Events.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision ISDA 2002 Equity Index Adjustment Events.
	 *
	 */
	IndexAdjustmentEvents getIndexAdjustmentEvents();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision ISDA 2002 Equity Additional Disruption Events.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision ISDA 2002 Equity Additional Disruption Events.
	 *
	 */
	AdditionalDisruptionEvents getAdditionalDisruptionEvents();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, failure to deliver is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, failure to deliver is applicable.
	 *
	 */
	Boolean getFailureToDeliver();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision ISDA 2002 Equity Derivative Representations.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision ISDA 2002 Equity Derivative Representations.
	 *
	 */
	Representations getRepresentations();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The terms "Nationalisation" and "Insolvency" have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The terms "Nationalisation" and "Insolvency" have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 */
	NationalisationOrInsolvencyOrDelistingEventEnum getNationalisationOrInsolvency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The term "Delisting" has the meaning defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The term "Delisting" has the meaning defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 */
	NationalisationOrInsolvencyOrDelistingEventEnum getDelisting();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A short form unique identifier for a related exchange. If the element is not present then the exchange shall be the primary exchange on which listed futures and options on the underlying are listed. The term "Exchange" is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A short form unique identifier for a related exchange. If the element is not present then the exchange shall be the primary exchange on which listed futures and options on the underlying are listed. The term "Exchange" is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 */
	List<? extends ExchangeId> getRelatedExchangeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A short form unique identifier for an exchange on which the reference option contract is listed. This is to address the case where the reference exchange for the future is different than the one for the option. The options Exchange is referenced on share options when Merger Elections are selected as Options Exchange Adjustment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A short form unique identifier for an exchange on which the reference option contract is listed. This is to address the case where the reference exchange for the future is different than the one for the option. The options Exchange is referenced on share options when Merger Elections are selected as Options Exchange Adjustment.
	 *
	 */
	List<? extends ExchangeId> getOptionsExchangeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A short form unique identifier for a specified exchange. If the element is not present then the exchange shall be default terms as defined in the MCA; unless otherwise specified in the Transaction Supplement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A short form unique identifier for a specified exchange. If the element is not present then the exchange shall be default terms as defined in the MCA; unless otherwise specified in the Transaction Supplement.
	 *
	 */
	List<? extends ExchangeId> getSpecifiedExchangeId();

	/*********************** Build Methods  ***********************/
	ExtraordinaryEvents build();
	
	ExtraordinaryEvents.ExtraordinaryEventsBuilder toBuilder();
	
	static ExtraordinaryEvents.ExtraordinaryEventsBuilder builder() {
		return new ExtraordinaryEvents.ExtraordinaryEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExtraordinaryEvents> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExtraordinaryEvents> getType() {
		return ExtraordinaryEvents.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mergerEvents"), processor, EquityCorporateEvents.class, getMergerEvents());
		processor.processBasic(path.newSubPath("tenderOffer"), Boolean.class, getTenderOffer(), this);
		processRosetta(path.newSubPath("tenderOfferEvents"), processor, EquityCorporateEvents.class, getTenderOfferEvents());
		processor.processBasic(path.newSubPath("compositionOfCombinedConsideration"), Boolean.class, getCompositionOfCombinedConsideration(), this);
		processRosetta(path.newSubPath("indexAdjustmentEvents"), processor, IndexAdjustmentEvents.class, getIndexAdjustmentEvents());
		processRosetta(path.newSubPath("additionalDisruptionEvents"), processor, AdditionalDisruptionEvents.class, getAdditionalDisruptionEvents());
		processor.processBasic(path.newSubPath("failureToDeliver"), Boolean.class, getFailureToDeliver(), this);
		processRosetta(path.newSubPath("representations"), processor, Representations.class, getRepresentations());
		processor.processBasic(path.newSubPath("nationalisationOrInsolvency"), NationalisationOrInsolvencyOrDelistingEventEnum.class, getNationalisationOrInsolvency(), this);
		processor.processBasic(path.newSubPath("delisting"), NationalisationOrInsolvencyOrDelistingEventEnum.class, getDelisting(), this);
		processRosetta(path.newSubPath("relatedExchangeId"), processor, ExchangeId.class, getRelatedExchangeId());
		processRosetta(path.newSubPath("optionsExchangeId"), processor, ExchangeId.class, getOptionsExchangeId());
		processRosetta(path.newSubPath("specifiedExchangeId"), processor, ExchangeId.class, getSpecifiedExchangeId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExtraordinaryEventsBuilder extends ExtraordinaryEvents, RosettaModelObjectBuilder {
		EquityCorporateEvents.EquityCorporateEventsBuilder getOrCreateMergerEvents();
		@Override
		EquityCorporateEvents.EquityCorporateEventsBuilder getMergerEvents();
		EquityCorporateEvents.EquityCorporateEventsBuilder getOrCreateTenderOfferEvents();
		@Override
		EquityCorporateEvents.EquityCorporateEventsBuilder getTenderOfferEvents();
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder getOrCreateIndexAdjustmentEvents();
		@Override
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder getIndexAdjustmentEvents();
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder getOrCreateAdditionalDisruptionEvents();
		@Override
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder getAdditionalDisruptionEvents();
		Representations.RepresentationsBuilder getOrCreateRepresentations();
		@Override
		Representations.RepresentationsBuilder getRepresentations();
		ExchangeId.ExchangeIdBuilder getOrCreateRelatedExchangeId(int index);
		@Override
		List<? extends ExchangeId.ExchangeIdBuilder> getRelatedExchangeId();
		ExchangeId.ExchangeIdBuilder getOrCreateOptionsExchangeId(int index);
		@Override
		List<? extends ExchangeId.ExchangeIdBuilder> getOptionsExchangeId();
		ExchangeId.ExchangeIdBuilder getOrCreateSpecifiedExchangeId(int index);
		@Override
		List<? extends ExchangeId.ExchangeIdBuilder> getSpecifiedExchangeId();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setMergerEvents(EquityCorporateEvents mergerEvents);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setTenderOffer(Boolean tenderOffer);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setTenderOfferEvents(EquityCorporateEvents tenderOfferEvents);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setCompositionOfCombinedConsideration(Boolean compositionOfCombinedConsideration);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setIndexAdjustmentEvents(IndexAdjustmentEvents indexAdjustmentEvents);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setAdditionalDisruptionEvents(AdditionalDisruptionEvents additionalDisruptionEvents);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setFailureToDeliver(Boolean failureToDeliver);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setRepresentations(Representations representations);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setNationalisationOrInsolvency(NationalisationOrInsolvencyOrDelistingEventEnum nationalisationOrInsolvency);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setDelisting(NationalisationOrInsolvencyOrDelistingEventEnum delisting);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder addRelatedExchangeId(ExchangeId relatedExchangeId);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder addRelatedExchangeId(ExchangeId relatedExchangeId, int idx);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder addOptionsExchangeId(ExchangeId optionsExchangeId);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder addOptionsExchangeId(ExchangeId optionsExchangeId, int idx);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId, int idx);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mergerEvents"), processor, EquityCorporateEvents.EquityCorporateEventsBuilder.class, getMergerEvents());
			processor.processBasic(path.newSubPath("tenderOffer"), Boolean.class, getTenderOffer(), this);
			processRosetta(path.newSubPath("tenderOfferEvents"), processor, EquityCorporateEvents.EquityCorporateEventsBuilder.class, getTenderOfferEvents());
			processor.processBasic(path.newSubPath("compositionOfCombinedConsideration"), Boolean.class, getCompositionOfCombinedConsideration(), this);
			processRosetta(path.newSubPath("indexAdjustmentEvents"), processor, IndexAdjustmentEvents.IndexAdjustmentEventsBuilder.class, getIndexAdjustmentEvents());
			processRosetta(path.newSubPath("additionalDisruptionEvents"), processor, AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder.class, getAdditionalDisruptionEvents());
			processor.processBasic(path.newSubPath("failureToDeliver"), Boolean.class, getFailureToDeliver(), this);
			processRosetta(path.newSubPath("representations"), processor, Representations.RepresentationsBuilder.class, getRepresentations());
			processor.processBasic(path.newSubPath("nationalisationOrInsolvency"), NationalisationOrInsolvencyOrDelistingEventEnum.class, getNationalisationOrInsolvency(), this);
			processor.processBasic(path.newSubPath("delisting"), NationalisationOrInsolvencyOrDelistingEventEnum.class, getDelisting(), this);
			processRosetta(path.newSubPath("relatedExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getRelatedExchangeId());
			processRosetta(path.newSubPath("optionsExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getOptionsExchangeId());
			processRosetta(path.newSubPath("specifiedExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getSpecifiedExchangeId());
		}
		

		ExtraordinaryEvents.ExtraordinaryEventsBuilder prune();
	}

	/*********************** Immutable Implementation of ExtraordinaryEvents  ***********************/
	class ExtraordinaryEventsImpl implements ExtraordinaryEvents {
		private final EquityCorporateEvents mergerEvents;
		private final Boolean tenderOffer;
		private final EquityCorporateEvents tenderOfferEvents;
		private final Boolean compositionOfCombinedConsideration;
		private final IndexAdjustmentEvents indexAdjustmentEvents;
		private final AdditionalDisruptionEvents additionalDisruptionEvents;
		private final Boolean failureToDeliver;
		private final Representations representations;
		private final NationalisationOrInsolvencyOrDelistingEventEnum nationalisationOrInsolvency;
		private final NationalisationOrInsolvencyOrDelistingEventEnum delisting;
		private final List<? extends ExchangeId> relatedExchangeId;
		private final List<? extends ExchangeId> optionsExchangeId;
		private final List<? extends ExchangeId> specifiedExchangeId;
		
		protected ExtraordinaryEventsImpl(ExtraordinaryEvents.ExtraordinaryEventsBuilder builder) {
			this.mergerEvents = ofNullable(builder.getMergerEvents()).map(f->f.build()).orElse(null);
			this.tenderOffer = builder.getTenderOffer();
			this.tenderOfferEvents = ofNullable(builder.getTenderOfferEvents()).map(f->f.build()).orElse(null);
			this.compositionOfCombinedConsideration = builder.getCompositionOfCombinedConsideration();
			this.indexAdjustmentEvents = ofNullable(builder.getIndexAdjustmentEvents()).map(f->f.build()).orElse(null);
			this.additionalDisruptionEvents = ofNullable(builder.getAdditionalDisruptionEvents()).map(f->f.build()).orElse(null);
			this.failureToDeliver = builder.getFailureToDeliver();
			this.representations = ofNullable(builder.getRepresentations()).map(f->f.build()).orElse(null);
			this.nationalisationOrInsolvency = builder.getNationalisationOrInsolvency();
			this.delisting = builder.getDelisting();
			this.relatedExchangeId = ofNullable(builder.getRelatedExchangeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.optionsExchangeId = ofNullable(builder.getOptionsExchangeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.specifiedExchangeId = ofNullable(builder.getSpecifiedExchangeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mergerEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mergerEvents")
		public EquityCorporateEvents getMergerEvents() {
			return mergerEvents;
		}
		
		@Override
		@RosettaAttribute("tenderOffer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenderOffer")
		public Boolean getTenderOffer() {
			return tenderOffer;
		}
		
		@Override
		@RosettaAttribute("tenderOfferEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenderOfferEvents")
		public EquityCorporateEvents getTenderOfferEvents() {
			return tenderOfferEvents;
		}
		
		@Override
		@RosettaAttribute("compositionOfCombinedConsideration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compositionOfCombinedConsideration")
		public Boolean getCompositionOfCombinedConsideration() {
			return compositionOfCombinedConsideration;
		}
		
		@Override
		@RosettaAttribute("indexAdjustmentEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexAdjustmentEvents")
		public IndexAdjustmentEvents getIndexAdjustmentEvents() {
			return indexAdjustmentEvents;
		}
		
		@Override
		@RosettaAttribute("additionalDisruptionEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalDisruptionEvents")
		public AdditionalDisruptionEvents getAdditionalDisruptionEvents() {
			return additionalDisruptionEvents;
		}
		
		@Override
		@RosettaAttribute("failureToDeliver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("failureToDeliver")
		public Boolean getFailureToDeliver() {
			return failureToDeliver;
		}
		
		@Override
		@RosettaAttribute("representations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("representations")
		public Representations getRepresentations() {
			return representations;
		}
		
		@Override
		@RosettaAttribute("nationalisationOrInsolvency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nationalisationOrInsolvency")
		public NationalisationOrInsolvencyOrDelistingEventEnum getNationalisationOrInsolvency() {
			return nationalisationOrInsolvency;
		}
		
		@Override
		@RosettaAttribute("delisting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delisting")
		public NationalisationOrInsolvencyOrDelistingEventEnum getDelisting() {
			return delisting;
		}
		
		@Override
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		public List<? extends ExchangeId> getRelatedExchangeId() {
			return relatedExchangeId;
		}
		
		@Override
		@RosettaAttribute("optionsExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionsExchangeId")
		public List<? extends ExchangeId> getOptionsExchangeId() {
			return optionsExchangeId;
		}
		
		@Override
		@RosettaAttribute("specifiedExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("specifiedExchangeId")
		public List<? extends ExchangeId> getSpecifiedExchangeId() {
			return specifiedExchangeId;
		}
		
		@Override
		public ExtraordinaryEvents build() {
			return this;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder toBuilder() {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExtraordinaryEvents.ExtraordinaryEventsBuilder builder) {
			ofNullable(getMergerEvents()).ifPresent(builder::setMergerEvents);
			ofNullable(getTenderOffer()).ifPresent(builder::setTenderOffer);
			ofNullable(getTenderOfferEvents()).ifPresent(builder::setTenderOfferEvents);
			ofNullable(getCompositionOfCombinedConsideration()).ifPresent(builder::setCompositionOfCombinedConsideration);
			ofNullable(getIndexAdjustmentEvents()).ifPresent(builder::setIndexAdjustmentEvents);
			ofNullable(getAdditionalDisruptionEvents()).ifPresent(builder::setAdditionalDisruptionEvents);
			ofNullable(getFailureToDeliver()).ifPresent(builder::setFailureToDeliver);
			ofNullable(getRepresentations()).ifPresent(builder::setRepresentations);
			ofNullable(getNationalisationOrInsolvency()).ifPresent(builder::setNationalisationOrInsolvency);
			ofNullable(getDelisting()).ifPresent(builder::setDelisting);
			ofNullable(getRelatedExchangeId()).ifPresent(builder::setRelatedExchangeId);
			ofNullable(getOptionsExchangeId()).ifPresent(builder::setOptionsExchangeId);
			ofNullable(getSpecifiedExchangeId()).ifPresent(builder::setSpecifiedExchangeId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtraordinaryEvents _that = getType().cast(o);
		
			if (!Objects.equals(mergerEvents, _that.getMergerEvents())) return false;
			if (!Objects.equals(tenderOffer, _that.getTenderOffer())) return false;
			if (!Objects.equals(tenderOfferEvents, _that.getTenderOfferEvents())) return false;
			if (!Objects.equals(compositionOfCombinedConsideration, _that.getCompositionOfCombinedConsideration())) return false;
			if (!Objects.equals(indexAdjustmentEvents, _that.getIndexAdjustmentEvents())) return false;
			if (!Objects.equals(additionalDisruptionEvents, _that.getAdditionalDisruptionEvents())) return false;
			if (!Objects.equals(failureToDeliver, _that.getFailureToDeliver())) return false;
			if (!Objects.equals(representations, _that.getRepresentations())) return false;
			if (!Objects.equals(nationalisationOrInsolvency, _that.getNationalisationOrInsolvency())) return false;
			if (!Objects.equals(delisting, _that.getDelisting())) return false;
			if (!ListEquals.listEquals(relatedExchangeId, _that.getRelatedExchangeId())) return false;
			if (!ListEquals.listEquals(optionsExchangeId, _that.getOptionsExchangeId())) return false;
			if (!ListEquals.listEquals(specifiedExchangeId, _that.getSpecifiedExchangeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mergerEvents != null ? mergerEvents.hashCode() : 0);
			_result = 31 * _result + (tenderOffer != null ? tenderOffer.hashCode() : 0);
			_result = 31 * _result + (tenderOfferEvents != null ? tenderOfferEvents.hashCode() : 0);
			_result = 31 * _result + (compositionOfCombinedConsideration != null ? compositionOfCombinedConsideration.hashCode() : 0);
			_result = 31 * _result + (indexAdjustmentEvents != null ? indexAdjustmentEvents.hashCode() : 0);
			_result = 31 * _result + (additionalDisruptionEvents != null ? additionalDisruptionEvents.hashCode() : 0);
			_result = 31 * _result + (failureToDeliver != null ? failureToDeliver.hashCode() : 0);
			_result = 31 * _result + (representations != null ? representations.hashCode() : 0);
			_result = 31 * _result + (nationalisationOrInsolvency != null ? nationalisationOrInsolvency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delisting != null ? delisting.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (relatedExchangeId != null ? relatedExchangeId.hashCode() : 0);
			_result = 31 * _result + (optionsExchangeId != null ? optionsExchangeId.hashCode() : 0);
			_result = 31 * _result + (specifiedExchangeId != null ? specifiedExchangeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtraordinaryEvents {" +
				"mergerEvents=" + this.mergerEvents + ", " +
				"tenderOffer=" + this.tenderOffer + ", " +
				"tenderOfferEvents=" + this.tenderOfferEvents + ", " +
				"compositionOfCombinedConsideration=" + this.compositionOfCombinedConsideration + ", " +
				"indexAdjustmentEvents=" + this.indexAdjustmentEvents + ", " +
				"additionalDisruptionEvents=" + this.additionalDisruptionEvents + ", " +
				"failureToDeliver=" + this.failureToDeliver + ", " +
				"representations=" + this.representations + ", " +
				"nationalisationOrInsolvency=" + this.nationalisationOrInsolvency + ", " +
				"delisting=" + this.delisting + ", " +
				"relatedExchangeId=" + this.relatedExchangeId + ", " +
				"optionsExchangeId=" + this.optionsExchangeId + ", " +
				"specifiedExchangeId=" + this.specifiedExchangeId +
			'}';
		}
	}

	/*********************** Builder Implementation of ExtraordinaryEvents  ***********************/
	class ExtraordinaryEventsBuilderImpl implements ExtraordinaryEvents.ExtraordinaryEventsBuilder {
	
		protected EquityCorporateEvents.EquityCorporateEventsBuilder mergerEvents;
		protected Boolean tenderOffer;
		protected EquityCorporateEvents.EquityCorporateEventsBuilder tenderOfferEvents;
		protected Boolean compositionOfCombinedConsideration;
		protected IndexAdjustmentEvents.IndexAdjustmentEventsBuilder indexAdjustmentEvents;
		protected AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder additionalDisruptionEvents;
		protected Boolean failureToDeliver;
		protected Representations.RepresentationsBuilder representations;
		protected NationalisationOrInsolvencyOrDelistingEventEnum nationalisationOrInsolvency;
		protected NationalisationOrInsolvencyOrDelistingEventEnum delisting;
		protected List<ExchangeId.ExchangeIdBuilder> relatedExchangeId = new ArrayList<>();
		protected List<ExchangeId.ExchangeIdBuilder> optionsExchangeId = new ArrayList<>();
		protected List<ExchangeId.ExchangeIdBuilder> specifiedExchangeId = new ArrayList<>();
		
		@Override
		@RosettaAttribute("mergerEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mergerEvents")
		public EquityCorporateEvents.EquityCorporateEventsBuilder getMergerEvents() {
			return mergerEvents;
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder getOrCreateMergerEvents() {
			EquityCorporateEvents.EquityCorporateEventsBuilder result;
			if (mergerEvents!=null) {
				result = mergerEvents;
			}
			else {
				result = mergerEvents = EquityCorporateEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tenderOffer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenderOffer")
		public Boolean getTenderOffer() {
			return tenderOffer;
		}
		
		@Override
		@RosettaAttribute("tenderOfferEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenderOfferEvents")
		public EquityCorporateEvents.EquityCorporateEventsBuilder getTenderOfferEvents() {
			return tenderOfferEvents;
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder getOrCreateTenderOfferEvents() {
			EquityCorporateEvents.EquityCorporateEventsBuilder result;
			if (tenderOfferEvents!=null) {
				result = tenderOfferEvents;
			}
			else {
				result = tenderOfferEvents = EquityCorporateEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compositionOfCombinedConsideration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compositionOfCombinedConsideration")
		public Boolean getCompositionOfCombinedConsideration() {
			return compositionOfCombinedConsideration;
		}
		
		@Override
		@RosettaAttribute("indexAdjustmentEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexAdjustmentEvents")
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder getIndexAdjustmentEvents() {
			return indexAdjustmentEvents;
		}
		
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder getOrCreateIndexAdjustmentEvents() {
			IndexAdjustmentEvents.IndexAdjustmentEventsBuilder result;
			if (indexAdjustmentEvents!=null) {
				result = indexAdjustmentEvents;
			}
			else {
				result = indexAdjustmentEvents = IndexAdjustmentEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalDisruptionEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalDisruptionEvents")
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder getAdditionalDisruptionEvents() {
			return additionalDisruptionEvents;
		}
		
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder getOrCreateAdditionalDisruptionEvents() {
			AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder result;
			if (additionalDisruptionEvents!=null) {
				result = additionalDisruptionEvents;
			}
			else {
				result = additionalDisruptionEvents = AdditionalDisruptionEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("failureToDeliver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("failureToDeliver")
		public Boolean getFailureToDeliver() {
			return failureToDeliver;
		}
		
		@Override
		@RosettaAttribute("representations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("representations")
		public Representations.RepresentationsBuilder getRepresentations() {
			return representations;
		}
		
		@Override
		public Representations.RepresentationsBuilder getOrCreateRepresentations() {
			Representations.RepresentationsBuilder result;
			if (representations!=null) {
				result = representations;
			}
			else {
				result = representations = Representations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nationalisationOrInsolvency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nationalisationOrInsolvency")
		public NationalisationOrInsolvencyOrDelistingEventEnum getNationalisationOrInsolvency() {
			return nationalisationOrInsolvency;
		}
		
		@Override
		@RosettaAttribute("delisting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delisting")
		public NationalisationOrInsolvencyOrDelistingEventEnum getDelisting() {
			return delisting;
		}
		
		@Override
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		public List<? extends ExchangeId.ExchangeIdBuilder> getRelatedExchangeId() {
			return relatedExchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateRelatedExchangeId(int index) {
			if (relatedExchangeId==null) {
				this.relatedExchangeId = new ArrayList<>();
			}
			return getIndex(relatedExchangeId, index, () -> {
						ExchangeId.ExchangeIdBuilder newRelatedExchangeId = ExchangeId.builder();
						return newRelatedExchangeId;
					});
		}
		
		@Override
		@RosettaAttribute("optionsExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionsExchangeId")
		public List<? extends ExchangeId.ExchangeIdBuilder> getOptionsExchangeId() {
			return optionsExchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateOptionsExchangeId(int index) {
			if (optionsExchangeId==null) {
				this.optionsExchangeId = new ArrayList<>();
			}
			return getIndex(optionsExchangeId, index, () -> {
						ExchangeId.ExchangeIdBuilder newOptionsExchangeId = ExchangeId.builder();
						return newOptionsExchangeId;
					});
		}
		
		@Override
		@RosettaAttribute("specifiedExchangeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("specifiedExchangeId")
		public List<? extends ExchangeId.ExchangeIdBuilder> getSpecifiedExchangeId() {
			return specifiedExchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateSpecifiedExchangeId(int index) {
			if (specifiedExchangeId==null) {
				this.specifiedExchangeId = new ArrayList<>();
			}
			return getIndex(specifiedExchangeId, index, () -> {
						ExchangeId.ExchangeIdBuilder newSpecifiedExchangeId = ExchangeId.builder();
						return newSpecifiedExchangeId;
					});
		}
		
		@RosettaAttribute("mergerEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mergerEvents")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setMergerEvents(EquityCorporateEvents _mergerEvents) {
			this.mergerEvents = _mergerEvents == null ? null : _mergerEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tenderOffer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tenderOffer")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setTenderOffer(Boolean _tenderOffer) {
			this.tenderOffer = _tenderOffer == null ? null : _tenderOffer;
			return this;
		}
		
		@RosettaAttribute("tenderOfferEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tenderOfferEvents")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setTenderOfferEvents(EquityCorporateEvents _tenderOfferEvents) {
			this.tenderOfferEvents = _tenderOfferEvents == null ? null : _tenderOfferEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("compositionOfCombinedConsideration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compositionOfCombinedConsideration")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setCompositionOfCombinedConsideration(Boolean _compositionOfCombinedConsideration) {
			this.compositionOfCombinedConsideration = _compositionOfCombinedConsideration == null ? null : _compositionOfCombinedConsideration;
			return this;
		}
		
		@RosettaAttribute("indexAdjustmentEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexAdjustmentEvents")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setIndexAdjustmentEvents(IndexAdjustmentEvents _indexAdjustmentEvents) {
			this.indexAdjustmentEvents = _indexAdjustmentEvents == null ? null : _indexAdjustmentEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalDisruptionEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalDisruptionEvents")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setAdditionalDisruptionEvents(AdditionalDisruptionEvents _additionalDisruptionEvents) {
			this.additionalDisruptionEvents = _additionalDisruptionEvents == null ? null : _additionalDisruptionEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("failureToDeliver")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("failureToDeliver")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setFailureToDeliver(Boolean _failureToDeliver) {
			this.failureToDeliver = _failureToDeliver == null ? null : _failureToDeliver;
			return this;
		}
		
		@RosettaAttribute("representations")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("representations")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setRepresentations(Representations _representations) {
			this.representations = _representations == null ? null : _representations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nationalisationOrInsolvency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nationalisationOrInsolvency")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setNationalisationOrInsolvency(NationalisationOrInsolvencyOrDelistingEventEnum _nationalisationOrInsolvency) {
			this.nationalisationOrInsolvency = _nationalisationOrInsolvency == null ? null : _nationalisationOrInsolvency;
			return this;
		}
		
		@RosettaAttribute("delisting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delisting")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setDelisting(NationalisationOrInsolvencyOrDelistingEventEnum _delisting) {
			this.delisting = _delisting == null ? null : _delisting;
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId) {
			if (_relatedExchangeId != null) {
				this.relatedExchangeId.add(_relatedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId, int idx) {
			getIndex(this.relatedExchangeId, idx, () -> _relatedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
			if (relatedExchangeIds != null) {
				for (final ExchangeId toAdd : relatedExchangeIds) {
					this.relatedExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
			if (relatedExchangeIds == null) {
				this.relatedExchangeId = new ArrayList<>();
			} else {
				this.relatedExchangeId = relatedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionsExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionsExchangeId")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId) {
			if (_optionsExchangeId != null) {
				this.optionsExchangeId.add(_optionsExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId, int idx) {
			getIndex(this.optionsExchangeId, idx, () -> _optionsExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
			if (optionsExchangeIds != null) {
				for (final ExchangeId toAdd : optionsExchangeIds) {
					this.optionsExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("optionsExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("optionsExchangeId")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
			if (optionsExchangeIds == null) {
				this.optionsExchangeId = new ArrayList<>();
			} else {
				this.optionsExchangeId = optionsExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("specifiedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("specifiedExchangeId")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId) {
			if (_specifiedExchangeId != null) {
				this.specifiedExchangeId.add(_specifiedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId, int idx) {
			getIndex(this.specifiedExchangeId, idx, () -> _specifiedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds != null) {
				for (final ExchangeId toAdd : specifiedExchangeIds) {
					this.specifiedExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("specifiedExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("specifiedExchangeId")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds == null) {
				this.specifiedExchangeId = new ArrayList<>();
			} else {
				this.specifiedExchangeId = specifiedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExtraordinaryEvents build() {
			return new ExtraordinaryEvents.ExtraordinaryEventsImpl(this);
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder prune() {
			if (mergerEvents!=null && !mergerEvents.prune().hasData()) mergerEvents = null;
			if (tenderOfferEvents!=null && !tenderOfferEvents.prune().hasData()) tenderOfferEvents = null;
			if (indexAdjustmentEvents!=null && !indexAdjustmentEvents.prune().hasData()) indexAdjustmentEvents = null;
			if (additionalDisruptionEvents!=null && !additionalDisruptionEvents.prune().hasData()) additionalDisruptionEvents = null;
			if (representations!=null && !representations.prune().hasData()) representations = null;
			relatedExchangeId = relatedExchangeId.stream().filter(b->b!=null).<ExchangeId.ExchangeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			optionsExchangeId = optionsExchangeId.stream().filter(b->b!=null).<ExchangeId.ExchangeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			specifiedExchangeId = specifiedExchangeId.stream().filter(b->b!=null).<ExchangeId.ExchangeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMergerEvents()!=null && getMergerEvents().hasData()) return true;
			if (getTenderOffer()!=null) return true;
			if (getTenderOfferEvents()!=null && getTenderOfferEvents().hasData()) return true;
			if (getCompositionOfCombinedConsideration()!=null) return true;
			if (getIndexAdjustmentEvents()!=null && getIndexAdjustmentEvents().hasData()) return true;
			if (getAdditionalDisruptionEvents()!=null && getAdditionalDisruptionEvents().hasData()) return true;
			if (getFailureToDeliver()!=null) return true;
			if (getRepresentations()!=null && getRepresentations().hasData()) return true;
			if (getNationalisationOrInsolvency()!=null) return true;
			if (getDelisting()!=null) return true;
			if (getRelatedExchangeId()!=null && getRelatedExchangeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOptionsExchangeId()!=null && getOptionsExchangeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpecifiedExchangeId()!=null && getSpecifiedExchangeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder o = (ExtraordinaryEvents.ExtraordinaryEventsBuilder) other;
			
			merger.mergeRosetta(getMergerEvents(), o.getMergerEvents(), this::setMergerEvents);
			merger.mergeRosetta(getTenderOfferEvents(), o.getTenderOfferEvents(), this::setTenderOfferEvents);
			merger.mergeRosetta(getIndexAdjustmentEvents(), o.getIndexAdjustmentEvents(), this::setIndexAdjustmentEvents);
			merger.mergeRosetta(getAdditionalDisruptionEvents(), o.getAdditionalDisruptionEvents(), this::setAdditionalDisruptionEvents);
			merger.mergeRosetta(getRepresentations(), o.getRepresentations(), this::setRepresentations);
			merger.mergeRosetta(getRelatedExchangeId(), o.getRelatedExchangeId(), this::getOrCreateRelatedExchangeId);
			merger.mergeRosetta(getOptionsExchangeId(), o.getOptionsExchangeId(), this::getOrCreateOptionsExchangeId);
			merger.mergeRosetta(getSpecifiedExchangeId(), o.getSpecifiedExchangeId(), this::getOrCreateSpecifiedExchangeId);
			
			merger.mergeBasic(getTenderOffer(), o.getTenderOffer(), this::setTenderOffer);
			merger.mergeBasic(getCompositionOfCombinedConsideration(), o.getCompositionOfCombinedConsideration(), this::setCompositionOfCombinedConsideration);
			merger.mergeBasic(getFailureToDeliver(), o.getFailureToDeliver(), this::setFailureToDeliver);
			merger.mergeBasic(getNationalisationOrInsolvency(), o.getNationalisationOrInsolvency(), this::setNationalisationOrInsolvency);
			merger.mergeBasic(getDelisting(), o.getDelisting(), this::setDelisting);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtraordinaryEvents _that = getType().cast(o);
		
			if (!Objects.equals(mergerEvents, _that.getMergerEvents())) return false;
			if (!Objects.equals(tenderOffer, _that.getTenderOffer())) return false;
			if (!Objects.equals(tenderOfferEvents, _that.getTenderOfferEvents())) return false;
			if (!Objects.equals(compositionOfCombinedConsideration, _that.getCompositionOfCombinedConsideration())) return false;
			if (!Objects.equals(indexAdjustmentEvents, _that.getIndexAdjustmentEvents())) return false;
			if (!Objects.equals(additionalDisruptionEvents, _that.getAdditionalDisruptionEvents())) return false;
			if (!Objects.equals(failureToDeliver, _that.getFailureToDeliver())) return false;
			if (!Objects.equals(representations, _that.getRepresentations())) return false;
			if (!Objects.equals(nationalisationOrInsolvency, _that.getNationalisationOrInsolvency())) return false;
			if (!Objects.equals(delisting, _that.getDelisting())) return false;
			if (!ListEquals.listEquals(relatedExchangeId, _that.getRelatedExchangeId())) return false;
			if (!ListEquals.listEquals(optionsExchangeId, _that.getOptionsExchangeId())) return false;
			if (!ListEquals.listEquals(specifiedExchangeId, _that.getSpecifiedExchangeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mergerEvents != null ? mergerEvents.hashCode() : 0);
			_result = 31 * _result + (tenderOffer != null ? tenderOffer.hashCode() : 0);
			_result = 31 * _result + (tenderOfferEvents != null ? tenderOfferEvents.hashCode() : 0);
			_result = 31 * _result + (compositionOfCombinedConsideration != null ? compositionOfCombinedConsideration.hashCode() : 0);
			_result = 31 * _result + (indexAdjustmentEvents != null ? indexAdjustmentEvents.hashCode() : 0);
			_result = 31 * _result + (additionalDisruptionEvents != null ? additionalDisruptionEvents.hashCode() : 0);
			_result = 31 * _result + (failureToDeliver != null ? failureToDeliver.hashCode() : 0);
			_result = 31 * _result + (representations != null ? representations.hashCode() : 0);
			_result = 31 * _result + (nationalisationOrInsolvency != null ? nationalisationOrInsolvency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delisting != null ? delisting.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (relatedExchangeId != null ? relatedExchangeId.hashCode() : 0);
			_result = 31 * _result + (optionsExchangeId != null ? optionsExchangeId.hashCode() : 0);
			_result = 31 * _result + (specifiedExchangeId != null ? specifiedExchangeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtraordinaryEventsBuilder {" +
				"mergerEvents=" + this.mergerEvents + ", " +
				"tenderOffer=" + this.tenderOffer + ", " +
				"tenderOfferEvents=" + this.tenderOfferEvents + ", " +
				"compositionOfCombinedConsideration=" + this.compositionOfCombinedConsideration + ", " +
				"indexAdjustmentEvents=" + this.indexAdjustmentEvents + ", " +
				"additionalDisruptionEvents=" + this.additionalDisruptionEvents + ", " +
				"failureToDeliver=" + this.failureToDeliver + ", " +
				"representations=" + this.representations + ", " +
				"nationalisationOrInsolvency=" + this.nationalisationOrInsolvency + ", " +
				"delisting=" + this.delisting + ", " +
				"relatedExchangeId=" + this.relatedExchangeId + ", " +
				"optionsExchangeId=" + this.optionsExchangeId + ", " +
				"specifiedExchangeId=" + this.specifiedExchangeId +
			'}';
		}
	}
}
