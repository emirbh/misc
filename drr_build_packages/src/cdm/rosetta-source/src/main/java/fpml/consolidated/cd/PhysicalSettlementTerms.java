package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.PhysicalSettlementTermsMeta;
import fpml.consolidated.option.shared.SettlementTerms;
import fpml.consolidated.shared.Currency;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="PhysicalSettlementTerms", builder=PhysicalSettlementTerms.PhysicalSettlementTermsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PhysicalSettlementTerms", model="fpml", builder=PhysicalSettlementTerms.PhysicalSettlementTermsBuilderImpl.class, version="2.1.1")
public interface PhysicalSettlementTerms extends SettlementTerms {

	PhysicalSettlementTermsMeta metaData = new PhysicalSettlementTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of business days used in the determination of the physical settlement date. The physical settlement date is this number of business days after all applicable conditions to settlement are satisfied. If a number of business days is not specified fallback provisions apply for determining the number of business days. If Section 8.5/8.6 of the 1999/2003 ISDA Definitions are to apply the businessDaysNotSpecified element should be included. If a specified number of business days are to apply these should be specified in the businessDays element. If Section 8.5/8.6 of the 1999/2003 ISDA Definitions are to apply but capped at a maximum number of business days then the maximum number should be specified in the maximumBusinessDays element. ISDA 2003 Term: Physical Settlement Period
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of business days used in the determination of the physical settlement date. The physical settlement date is this number of business days after all applicable conditions to settlement are satisfied. If a number of business days is not specified fallback provisions apply for determining the number of business days. If Section 8.5/8.6 of the 1999/2003 ISDA Definitions are to apply the businessDaysNotSpecified element should be included. If a specified number of business days are to apply these should be specified in the businessDays element. If Section 8.5/8.6 of the 1999/2003 ISDA Definitions are to apply but capped at a maximum number of business days then the maximum number should be specified in the maximumBusinessDays element. ISDA 2003 Term: Physical Settlement Period
	 *
	 */
	PhysicalSettlementPeriod getPhysicalSettlementPeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the ISDA terms relevant to defining the deliverable obligations.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the ISDA terms relevant to defining the deliverable obligations.
	 *
	 */
	DeliverableObligations getDeliverableObligations();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If this element is specified and set to 'true', indicates that physical settlement must take place through the use of an escrow agent. (For Canadian counterparties this is always "Not Applicable". ISDA 2003 Term: Escrow.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If this element is specified and set to 'true', indicates that physical settlement must take place through the use of an escrow agent. (For Canadian counterparties this is always "Not Applicable". ISDA 2003 Term: Escrow.
	 *
	 */
	Boolean getEscrow();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If this element is specified and set to 'true', for a transaction documented under the 2003 ISDA Credit Derivatives Definitions, has the effect of incorporating the language set forth below into the confirmation. The section references are to the 2003 ISDA Credit Derivatives Definitions. Notwithstanding Section 1.7 or any provisions of Sections 9.9 or 9.10 to the contrary, but without prejudice to Section 9.3 and (where applicable) Sections 9.4, 9.5 and 9.6, if the Termination Date has not occurred on or prior to the date that is 60 Business Days following the Physical Settlement Date, such 60th Business Day shall be deemed to be the Termination Date with respect to this Transaction except in relation to any portion of the Transaction (an "Affected Portion") in respect of which: (1) a valid notice of Buy-in Price has been delivered that is effective fewer than three Business Days prior to such 60th Business Day, in which case the Termination Date for that Affected Portion shall be the third Business Day following the date on which such notice is effective; or (2) Buyer has purchased but not Delivered Deliverable Obligations validly specified by Seller pursuant to Section 9.10(b), in which case the Termination Date for that Affected Portion shall be the tenth Business Day following the date on which Seller validly specified such Deliverable Obligations to Buyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If this element is specified and set to 'true', for a transaction documented under the 2003 ISDA Credit Derivatives Definitions, has the effect of incorporating the language set forth below into the confirmation. The section references are to the 2003 ISDA Credit Derivatives Definitions. Notwithstanding Section 1.7 or any provisions of Sections 9.9 or 9.10 to the contrary, but without prejudice to Section 9.3 and (where applicable) Sections 9.4, 9.5 and 9.6, if the Termination Date has not occurred on or prior to the date that is 60 Business Days following the Physical Settlement Date, such 60th Business Day shall be deemed to be the Termination Date with respect to this Transaction except in relation to any portion of the Transaction (an "Affected Portion") in respect of which: (1) a valid notice of Buy-in Price has been delivered that is effective fewer than three Business Days prior to such 60th Business Day, in which case the Termination Date for that Affected Portion shall be the third Business Day following the date on which such notice is effective; or (2) Buyer has purchased but not Delivered Deliverable Obligations validly specified by Seller pursuant to Section 9.10(b), in which case the Termination Date for that Affected Portion shall be the tenth Business Day following the date on which Seller validly specified such Deliverable Obligations to Buyer.
	 *
	 */
	Boolean getSixtyBusinessDaySettlementCap();

	/*********************** Build Methods  ***********************/
	PhysicalSettlementTerms build();
	
	PhysicalSettlementTerms.PhysicalSettlementTermsBuilder toBuilder();
	
	static PhysicalSettlementTerms.PhysicalSettlementTermsBuilder builder() {
		return new PhysicalSettlementTerms.PhysicalSettlementTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PhysicalSettlementTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PhysicalSettlementTerms> getType() {
		return PhysicalSettlementTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("physicalSettlementPeriod"), processor, PhysicalSettlementPeriod.class, getPhysicalSettlementPeriod());
		processRosetta(path.newSubPath("deliverableObligations"), processor, DeliverableObligations.class, getDeliverableObligations());
		processor.processBasic(path.newSubPath("escrow"), Boolean.class, getEscrow(), this);
		processor.processBasic(path.newSubPath("sixtyBusinessDaySettlementCap"), Boolean.class, getSixtyBusinessDaySettlementCap(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PhysicalSettlementTermsBuilder extends PhysicalSettlementTerms, SettlementTerms.SettlementTermsBuilder {
		PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder getOrCreatePhysicalSettlementPeriod();
		@Override
		PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder getPhysicalSettlementPeriod();
		DeliverableObligations.DeliverableObligationsBuilder getOrCreateDeliverableObligations();
		@Override
		DeliverableObligations.DeliverableObligationsBuilder getDeliverableObligations();
		@Override
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setId(String id);
		@Override
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setSettlementCurrency(Currency settlementCurrency);
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setPhysicalSettlementPeriod(PhysicalSettlementPeriod physicalSettlementPeriod);
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setDeliverableObligations(DeliverableObligations deliverableObligations);
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setEscrow(Boolean escrow);
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setSixtyBusinessDaySettlementCap(Boolean sixtyBusinessDaySettlementCap);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("physicalSettlementPeriod"), processor, PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder.class, getPhysicalSettlementPeriod());
			processRosetta(path.newSubPath("deliverableObligations"), processor, DeliverableObligations.DeliverableObligationsBuilder.class, getDeliverableObligations());
			processor.processBasic(path.newSubPath("escrow"), Boolean.class, getEscrow(), this);
			processor.processBasic(path.newSubPath("sixtyBusinessDaySettlementCap"), Boolean.class, getSixtyBusinessDaySettlementCap(), this);
		}
		

		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder prune();
	}

	/*********************** Immutable Implementation of PhysicalSettlementTerms  ***********************/
	class PhysicalSettlementTermsImpl extends SettlementTerms.SettlementTermsImpl implements PhysicalSettlementTerms {
		private final PhysicalSettlementPeriod physicalSettlementPeriod;
		private final DeliverableObligations deliverableObligations;
		private final Boolean escrow;
		private final Boolean sixtyBusinessDaySettlementCap;
		
		protected PhysicalSettlementTermsImpl(PhysicalSettlementTerms.PhysicalSettlementTermsBuilder builder) {
			super(builder);
			this.physicalSettlementPeriod = ofNullable(builder.getPhysicalSettlementPeriod()).map(f->f.build()).orElse(null);
			this.deliverableObligations = ofNullable(builder.getDeliverableObligations()).map(f->f.build()).orElse(null);
			this.escrow = builder.getEscrow();
			this.sixtyBusinessDaySettlementCap = builder.getSixtyBusinessDaySettlementCap();
		}
		
		@Override
		@RosettaAttribute("physicalSettlementPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlementPeriod")
		public PhysicalSettlementPeriod getPhysicalSettlementPeriod() {
			return physicalSettlementPeriod;
		}
		
		@Override
		@RosettaAttribute("deliverableObligations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliverableObligations")
		public DeliverableObligations getDeliverableObligations() {
			return deliverableObligations;
		}
		
		@Override
		@RosettaAttribute("escrow")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrow")
		public Boolean getEscrow() {
			return escrow;
		}
		
		@Override
		@RosettaAttribute("sixtyBusinessDaySettlementCap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sixtyBusinessDaySettlementCap")
		public Boolean getSixtyBusinessDaySettlementCap() {
			return sixtyBusinessDaySettlementCap;
		}
		
		@Override
		public PhysicalSettlementTerms build() {
			return this;
		}
		
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder toBuilder() {
			PhysicalSettlementTerms.PhysicalSettlementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PhysicalSettlementTerms.PhysicalSettlementTermsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPhysicalSettlementPeriod()).ifPresent(builder::setPhysicalSettlementPeriod);
			ofNullable(getDeliverableObligations()).ifPresent(builder::setDeliverableObligations);
			ofNullable(getEscrow()).ifPresent(builder::setEscrow);
			ofNullable(getSixtyBusinessDaySettlementCap()).ifPresent(builder::setSixtyBusinessDaySettlementCap);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PhysicalSettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(physicalSettlementPeriod, _that.getPhysicalSettlementPeriod())) return false;
			if (!Objects.equals(deliverableObligations, _that.getDeliverableObligations())) return false;
			if (!Objects.equals(escrow, _that.getEscrow())) return false;
			if (!Objects.equals(sixtyBusinessDaySettlementCap, _that.getSixtyBusinessDaySettlementCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (physicalSettlementPeriod != null ? physicalSettlementPeriod.hashCode() : 0);
			_result = 31 * _result + (deliverableObligations != null ? deliverableObligations.hashCode() : 0);
			_result = 31 * _result + (escrow != null ? escrow.hashCode() : 0);
			_result = 31 * _result + (sixtyBusinessDaySettlementCap != null ? sixtyBusinessDaySettlementCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PhysicalSettlementTerms {" +
				"physicalSettlementPeriod=" + this.physicalSettlementPeriod + ", " +
				"deliverableObligations=" + this.deliverableObligations + ", " +
				"escrow=" + this.escrow + ", " +
				"sixtyBusinessDaySettlementCap=" + this.sixtyBusinessDaySettlementCap +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PhysicalSettlementTerms  ***********************/
	class PhysicalSettlementTermsBuilderImpl extends SettlementTerms.SettlementTermsBuilderImpl implements PhysicalSettlementTerms.PhysicalSettlementTermsBuilder {
	
		protected PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder physicalSettlementPeriod;
		protected DeliverableObligations.DeliverableObligationsBuilder deliverableObligations;
		protected Boolean escrow;
		protected Boolean sixtyBusinessDaySettlementCap;
		
		@Override
		@RosettaAttribute("physicalSettlementPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlementPeriod")
		public PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder getPhysicalSettlementPeriod() {
			return physicalSettlementPeriod;
		}
		
		@Override
		public PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder getOrCreatePhysicalSettlementPeriod() {
			PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder result;
			if (physicalSettlementPeriod!=null) {
				result = physicalSettlementPeriod;
			}
			else {
				result = physicalSettlementPeriod = PhysicalSettlementPeriod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliverableObligations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliverableObligations")
		public DeliverableObligations.DeliverableObligationsBuilder getDeliverableObligations() {
			return deliverableObligations;
		}
		
		@Override
		public DeliverableObligations.DeliverableObligationsBuilder getOrCreateDeliverableObligations() {
			DeliverableObligations.DeliverableObligationsBuilder result;
			if (deliverableObligations!=null) {
				result = deliverableObligations;
			}
			else {
				result = deliverableObligations = DeliverableObligations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("escrow")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrow")
		public Boolean getEscrow() {
			return escrow;
		}
		
		@Override
		@RosettaAttribute("sixtyBusinessDaySettlementCap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sixtyBusinessDaySettlementCap")
		public Boolean getSixtyBusinessDaySettlementCap() {
			return sixtyBusinessDaySettlementCap;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalSettlementPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalSettlementPeriod")
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setPhysicalSettlementPeriod(PhysicalSettlementPeriod _physicalSettlementPeriod) {
			this.physicalSettlementPeriod = _physicalSettlementPeriod == null ? null : _physicalSettlementPeriod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliverableObligations")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliverableObligations")
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setDeliverableObligations(DeliverableObligations _deliverableObligations) {
			this.deliverableObligations = _deliverableObligations == null ? null : _deliverableObligations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("escrow")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("escrow")
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setEscrow(Boolean _escrow) {
			this.escrow = _escrow == null ? null : _escrow;
			return this;
		}
		
		@RosettaAttribute("sixtyBusinessDaySettlementCap")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sixtyBusinessDaySettlementCap")
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setSixtyBusinessDaySettlementCap(Boolean _sixtyBusinessDaySettlementCap) {
			this.sixtyBusinessDaySettlementCap = _sixtyBusinessDaySettlementCap == null ? null : _sixtyBusinessDaySettlementCap;
			return this;
		}
		
		@Override
		public PhysicalSettlementTerms build() {
			return new PhysicalSettlementTerms.PhysicalSettlementTermsImpl(this);
		}
		
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder prune() {
			super.prune();
			if (physicalSettlementPeriod!=null && !physicalSettlementPeriod.prune().hasData()) physicalSettlementPeriod = null;
			if (deliverableObligations!=null && !deliverableObligations.prune().hasData()) deliverableObligations = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPhysicalSettlementPeriod()!=null && getPhysicalSettlementPeriod().hasData()) return true;
			if (getDeliverableObligations()!=null && getDeliverableObligations().hasData()) return true;
			if (getEscrow()!=null) return true;
			if (getSixtyBusinessDaySettlementCap()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PhysicalSettlementTerms.PhysicalSettlementTermsBuilder o = (PhysicalSettlementTerms.PhysicalSettlementTermsBuilder) other;
			
			merger.mergeRosetta(getPhysicalSettlementPeriod(), o.getPhysicalSettlementPeriod(), this::setPhysicalSettlementPeriod);
			merger.mergeRosetta(getDeliverableObligations(), o.getDeliverableObligations(), this::setDeliverableObligations);
			
			merger.mergeBasic(getEscrow(), o.getEscrow(), this::setEscrow);
			merger.mergeBasic(getSixtyBusinessDaySettlementCap(), o.getSixtyBusinessDaySettlementCap(), this::setSixtyBusinessDaySettlementCap);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PhysicalSettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(physicalSettlementPeriod, _that.getPhysicalSettlementPeriod())) return false;
			if (!Objects.equals(deliverableObligations, _that.getDeliverableObligations())) return false;
			if (!Objects.equals(escrow, _that.getEscrow())) return false;
			if (!Objects.equals(sixtyBusinessDaySettlementCap, _that.getSixtyBusinessDaySettlementCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (physicalSettlementPeriod != null ? physicalSettlementPeriod.hashCode() : 0);
			_result = 31 * _result + (deliverableObligations != null ? deliverableObligations.hashCode() : 0);
			_result = 31 * _result + (escrow != null ? escrow.hashCode() : 0);
			_result = 31 * _result + (sixtyBusinessDaySettlementCap != null ? sixtyBusinessDaySettlementCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PhysicalSettlementTermsBuilder {" +
				"physicalSettlementPeriod=" + this.physicalSettlementPeriod + ", " +
				"deliverableObligations=" + this.deliverableObligations + ", " +
				"escrow=" + this.escrow + ", " +
				"sixtyBusinessDaySettlementCap=" + this.sixtyBusinessDaySettlementCap +
			'}' + " " + super.toString();
		}
	}
}
