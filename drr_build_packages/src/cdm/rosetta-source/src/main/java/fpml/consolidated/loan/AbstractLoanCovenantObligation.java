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
import fpml.consolidated.loan.meta.AbstractLoanCovenantObligationMeta;
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
 * Provision An abstract type defining a loan covenant obligation baseline structure.
 *
 */
@RosettaDataType(value="AbstractLoanCovenantObligation", builder=AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLoanCovenantObligation", model="fpml", builder=AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilderImpl.class, version="2.1.1")
public interface AbstractLoanCovenantObligation extends LoanCovenantObligationSummary {

	AbstractLoanCovenantObligationMeta metaData = new AbstractLoanCovenantObligationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	AbstractLoanCovenantObligation build();
	
	AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder toBuilder();
	
	static AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder builder() {
		return new AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanCovenantObligation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLoanCovenantObligation> getType() {
		return AbstractLoanCovenantObligation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("covenantObligationId"), processor, CovenantObligationId.class, getCovenantObligationId());
		processRosetta(path.newSubPath("versionedCovenantObligationId"), processor, VersionedCovenantObligationId.class, getVersionedCovenantObligationId());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("obligatedParty"), processor, PartyReference.class, getObligatedParty());
		processRosetta(path.newSubPath("dealReference"), processor, DealReference.class, getDealReference());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanCovenantObligationBuilder extends AbstractLoanCovenantObligation, LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder {
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setId(String id);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setName(String name);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setPartyReference(PartyReference partyReference);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addCovenantObligationId(CovenantObligationId covenantObligationId);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addCovenantObligationId(CovenantObligationId covenantObligationId, int idx);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addCovenantObligationId(List<? extends CovenantObligationId> covenantObligationId);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setCovenantObligationId(List<? extends CovenantObligationId> covenantObligationId);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId versionedCovenantObligationId);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId versionedCovenantObligationId, int idx);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationId);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationId);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setObligatedParty(PartyReference obligatedParty);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setDealReference(DealReference dealReference);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addFacilityReference(FacilityReference facilityReference);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addFacilityReference(FacilityReference facilityReference, int idx);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addFacilityReference(List<? extends FacilityReference> facilityReference);
		@Override
		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setFacilityReference(List<? extends FacilityReference> facilityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("covenantObligationId"), processor, CovenantObligationId.CovenantObligationIdBuilder.class, getCovenantObligationId());
			processRosetta(path.newSubPath("versionedCovenantObligationId"), processor, VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder.class, getVersionedCovenantObligationId());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("obligatedParty"), processor, PartyReference.PartyReferenceBuilder.class, getObligatedParty());
			processRosetta(path.newSubPath("dealReference"), processor, DealReference.DealReferenceBuilder.class, getDealReference());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
		}
		

		AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanCovenantObligation  ***********************/
	class AbstractLoanCovenantObligationImpl extends LoanCovenantObligationSummary.LoanCovenantObligationSummaryImpl implements AbstractLoanCovenantObligation {
		
		protected AbstractLoanCovenantObligationImpl(AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder builder) {
			super(builder);
		}
		
		@Override
		public AbstractLoanCovenantObligation build() {
			return this;
		}
		
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder toBuilder() {
			AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder builder) {
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
			return "AbstractLoanCovenantObligation {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanCovenantObligation  ***********************/
	class AbstractLoanCovenantObligationBuilderImpl extends LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilderImpl implements AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("covenantObligationId")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addCovenantObligationId(CovenantObligationId _covenantObligationId) {
			if (_covenantObligationId != null) {
				this.covenantObligationId.add(_covenantObligationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addCovenantObligationId(CovenantObligationId _covenantObligationId, int idx) {
			getIndex(this.covenantObligationId, idx, () -> _covenantObligationId.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addCovenantObligationId(List<? extends CovenantObligationId> covenantObligationIds) {
			if (covenantObligationIds != null) {
				for (final CovenantObligationId toAdd : covenantObligationIds) {
					this.covenantObligationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("covenantObligationId")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setCovenantObligationId(List<? extends CovenantObligationId> covenantObligationIds) {
			if (covenantObligationIds == null) {
				this.covenantObligationId = new ArrayList<>();
			} else {
				this.covenantObligationId = covenantObligationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("versionedCovenantObligationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("versionedCovenantObligationId")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId _versionedCovenantObligationId) {
			if (_versionedCovenantObligationId != null) {
				this.versionedCovenantObligationId.add(_versionedCovenantObligationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId _versionedCovenantObligationId, int idx) {
			getIndex(this.versionedCovenantObligationId, idx, () -> _versionedCovenantObligationId.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationIds) {
			if (versionedCovenantObligationIds != null) {
				for (final VersionedCovenantObligationId toAdd : versionedCovenantObligationIds) {
					this.versionedCovenantObligationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("versionedCovenantObligationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("versionedCovenantObligationId")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationIds) {
			if (versionedCovenantObligationIds == null) {
				this.versionedCovenantObligationId = new ArrayList<>();
			} else {
				this.versionedCovenantObligationId = versionedCovenantObligationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("obligatedParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("obligatedParty")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setObligatedParty(PartyReference _obligatedParty) {
			this.obligatedParty = _obligatedParty == null ? null : _obligatedParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addFacilityReference(FacilityReference _facilityReference) {
			if (_facilityReference != null) {
				this.facilityReference.add(_facilityReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addFacilityReference(FacilityReference _facilityReference, int idx) {
			getIndex(this.facilityReference, idx, () -> _facilityReference.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder addFacilityReference(List<? extends FacilityReference> facilityReferences) {
			if (facilityReferences != null) {
				for (final FacilityReference toAdd : facilityReferences) {
					this.facilityReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder setFacilityReference(List<? extends FacilityReference> facilityReferences) {
			if (facilityReferences == null) {
				this.facilityReference = new ArrayList<>();
			} else {
				this.facilityReference = facilityReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AbstractLoanCovenantObligation build() {
			return new AbstractLoanCovenantObligation.AbstractLoanCovenantObligationImpl(this);
		}
		
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder prune() {
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
		public AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder o = (AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder) other;
			
			
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
			return "AbstractLoanCovenantObligationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
