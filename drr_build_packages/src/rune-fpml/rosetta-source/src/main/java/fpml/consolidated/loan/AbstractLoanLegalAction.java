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
import fpml.consolidated.loan.meta.AbstractLoanLegalActionMeta;
import fpml.consolidated.shared.PartyReference;
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
 * Provision An abstract type syndicated bank loan legal action definition.
 *
 */
@RosettaDataType(value="AbstractLoanLegalAction", builder=AbstractLoanLegalAction.AbstractLoanLegalActionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLoanLegalAction", model="fpml", builder=AbstractLoanLegalAction.AbstractLoanLegalActionBuilderImpl.class, version="2.1.1")
public interface AbstractLoanLegalAction extends LoanLegalActionSummary {

	AbstractLoanLegalActionMeta metaData = new AbstractLoanLegalActionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	AbstractLoanLegalAction build();
	
	AbstractLoanLegalAction.AbstractLoanLegalActionBuilder toBuilder();
	
	static AbstractLoanLegalAction.AbstractLoanLegalActionBuilder builder() {
		return new AbstractLoanLegalAction.AbstractLoanLegalActionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanLegalAction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLoanLegalAction> getType() {
		return AbstractLoanLegalAction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("legalActionId"), processor, LegalActionId.class, getLegalActionId());
		processRosetta(path.newSubPath("versionedLegalActionId"), processor, VersionedLegalActionId.class, getVersionedLegalActionId());
		processRosetta(path.newSubPath("actionDetails"), processor, LoanLegalActionDetails.class, getActionDetails());
		processRosetta(path.newSubPath("dealReference"), processor, DealReference.class, getDealReference());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanLegalActionBuilder extends AbstractLoanLegalAction, LoanLegalActionSummary.LoanLegalActionSummaryBuilder {
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setId(String id);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setName(String name);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setPartyReference(PartyReference partyReference);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addLegalActionId(LegalActionId legalActionId);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addLegalActionId(LegalActionId legalActionId, int idx);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addLegalActionId(List<? extends LegalActionId> legalActionId);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setLegalActionId(List<? extends LegalActionId> legalActionId);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addVersionedLegalActionId(VersionedLegalActionId versionedLegalActionId);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addVersionedLegalActionId(VersionedLegalActionId versionedLegalActionId, int idx);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionId);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionId);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setActionDetails(LoanLegalActionDetails actionDetails);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setDealReference(DealReference dealReference);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addFacilityReference(FacilityReference facilityReference);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addFacilityReference(FacilityReference facilityReference, int idx);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addFacilityReference(List<? extends FacilityReference> facilityReference);
		@Override
		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setFacilityReference(List<? extends FacilityReference> facilityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("legalActionId"), processor, LegalActionId.LegalActionIdBuilder.class, getLegalActionId());
			processRosetta(path.newSubPath("versionedLegalActionId"), processor, VersionedLegalActionId.VersionedLegalActionIdBuilder.class, getVersionedLegalActionId());
			processRosetta(path.newSubPath("actionDetails"), processor, LoanLegalActionDetails.LoanLegalActionDetailsBuilder.class, getActionDetails());
			processRosetta(path.newSubPath("dealReference"), processor, DealReference.DealReferenceBuilder.class, getDealReference());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
		}
		

		AbstractLoanLegalAction.AbstractLoanLegalActionBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanLegalAction  ***********************/
	class AbstractLoanLegalActionImpl extends LoanLegalActionSummary.LoanLegalActionSummaryImpl implements AbstractLoanLegalAction {
		
		protected AbstractLoanLegalActionImpl(AbstractLoanLegalAction.AbstractLoanLegalActionBuilder builder) {
			super(builder);
		}
		
		@Override
		public AbstractLoanLegalAction build() {
			return this;
		}
		
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder toBuilder() {
			AbstractLoanLegalAction.AbstractLoanLegalActionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanLegalAction.AbstractLoanLegalActionBuilder builder) {
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
			return "AbstractLoanLegalAction {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanLegalAction  ***********************/
	class AbstractLoanLegalActionBuilderImpl extends LoanLegalActionSummary.LoanLegalActionSummaryBuilderImpl implements AbstractLoanLegalAction.AbstractLoanLegalActionBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legalActionId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legalActionId")
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addLegalActionId(LegalActionId _legalActionId) {
			if (_legalActionId != null) {
				this.legalActionId.add(_legalActionId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addLegalActionId(LegalActionId _legalActionId, int idx) {
			getIndex(this.legalActionId, idx, () -> _legalActionId.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addLegalActionId(List<? extends LegalActionId> legalActionIds) {
			if (legalActionIds != null) {
				for (final LegalActionId toAdd : legalActionIds) {
					this.legalActionId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("legalActionId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("legalActionId")
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setLegalActionId(List<? extends LegalActionId> legalActionIds) {
			if (legalActionIds == null) {
				this.legalActionId = new ArrayList<>();
			} else {
				this.legalActionId = legalActionIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("versionedLegalActionId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("versionedLegalActionId")
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addVersionedLegalActionId(VersionedLegalActionId _versionedLegalActionId) {
			if (_versionedLegalActionId != null) {
				this.versionedLegalActionId.add(_versionedLegalActionId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addVersionedLegalActionId(VersionedLegalActionId _versionedLegalActionId, int idx) {
			getIndex(this.versionedLegalActionId, idx, () -> _versionedLegalActionId.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionIds) {
			if (versionedLegalActionIds != null) {
				for (final VersionedLegalActionId toAdd : versionedLegalActionIds) {
					this.versionedLegalActionId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("versionedLegalActionId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("versionedLegalActionId")
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionIds) {
			if (versionedLegalActionIds == null) {
				this.versionedLegalActionId = new ArrayList<>();
			} else {
				this.versionedLegalActionId = versionedLegalActionIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("actionDetails")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionDetails")
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setActionDetails(LoanLegalActionDetails _actionDetails) {
			this.actionDetails = _actionDetails == null ? null : _actionDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addFacilityReference(FacilityReference _facilityReference) {
			if (_facilityReference != null) {
				this.facilityReference.add(_facilityReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addFacilityReference(FacilityReference _facilityReference, int idx) {
			getIndex(this.facilityReference, idx, () -> _facilityReference.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder addFacilityReference(List<? extends FacilityReference> facilityReferences) {
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
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder setFacilityReference(List<? extends FacilityReference> facilityReferences) {
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
		public AbstractLoanLegalAction build() {
			return new AbstractLoanLegalAction.AbstractLoanLegalActionImpl(this);
		}
		
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder prune() {
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
		public AbstractLoanLegalAction.AbstractLoanLegalActionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractLoanLegalAction.AbstractLoanLegalActionBuilder o = (AbstractLoanLegalAction.AbstractLoanLegalActionBuilder) other;
			
			
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
			return "AbstractLoanLegalActionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
