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
import fpml.consolidated.loan.meta.LoanLegalActionMeta;
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
 * version "confirmation-5.13"
 *
 * Provision A syndicated bank loan legal action definition.
 *
 */
@RosettaDataType(value="LoanLegalAction", builder=LoanLegalAction.LoanLegalActionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalAction", model="fpml", builder=LoanLegalAction.LoanLegalActionBuilderImpl.class, version="2.1.1")
public interface LoanLegalAction extends AbstractLoanLegalAction {

	LoanLegalActionMeta metaData = new LoanLegalActionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the approval of the legal action, including votes required for approval and the approval deadline date.
	 *
	 */
	ActionApproval getApproval();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Structure to describe the asset before the legal action.
	 *
	 */
	LoanLegalStructureBefore getBefore();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Structure to describe the asset after the legal action.
	 *
	 */
	LoanLegalStructureAfter getAfter();

	/*********************** Build Methods  ***********************/
	LoanLegalAction build();
	
	LoanLegalAction.LoanLegalActionBuilder toBuilder();
	
	static LoanLegalAction.LoanLegalActionBuilder builder() {
		return new LoanLegalAction.LoanLegalActionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalAction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalAction> getType() {
		return LoanLegalAction.class;
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
		processRosetta(path.newSubPath("approval"), processor, ActionApproval.class, getApproval());
		processRosetta(path.newSubPath("before"), processor, LoanLegalStructureBefore.class, getBefore());
		processRosetta(path.newSubPath("after"), processor, LoanLegalStructureAfter.class, getAfter());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionBuilder extends LoanLegalAction, AbstractLoanLegalAction.AbstractLoanLegalActionBuilder {
		ActionApproval.ActionApprovalBuilder getOrCreateApproval();
		@Override
		ActionApproval.ActionApprovalBuilder getApproval();
		LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder getOrCreateBefore();
		@Override
		LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder getBefore();
		LoanLegalStructureAfter.LoanLegalStructureAfterBuilder getOrCreateAfter();
		@Override
		LoanLegalStructureAfter.LoanLegalStructureAfterBuilder getAfter();
		@Override
		LoanLegalAction.LoanLegalActionBuilder setId(String id);
		@Override
		LoanLegalAction.LoanLegalActionBuilder setName(String name);
		@Override
		LoanLegalAction.LoanLegalActionBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanLegalAction.LoanLegalActionBuilder addLegalActionId(LegalActionId legalActionId);
		@Override
		LoanLegalAction.LoanLegalActionBuilder addLegalActionId(LegalActionId legalActionId, int idx);
		@Override
		LoanLegalAction.LoanLegalActionBuilder addLegalActionId(List<? extends LegalActionId> legalActionId);
		@Override
		LoanLegalAction.LoanLegalActionBuilder setLegalActionId(List<? extends LegalActionId> legalActionId);
		@Override
		LoanLegalAction.LoanLegalActionBuilder addVersionedLegalActionId(VersionedLegalActionId versionedLegalActionId);
		@Override
		LoanLegalAction.LoanLegalActionBuilder addVersionedLegalActionId(VersionedLegalActionId versionedLegalActionId, int idx);
		@Override
		LoanLegalAction.LoanLegalActionBuilder addVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionId);
		@Override
		LoanLegalAction.LoanLegalActionBuilder setVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionId);
		@Override
		LoanLegalAction.LoanLegalActionBuilder setActionDetails(LoanLegalActionDetails actionDetails);
		@Override
		LoanLegalAction.LoanLegalActionBuilder setDealReference(DealReference dealReference);
		@Override
		LoanLegalAction.LoanLegalActionBuilder addFacilityReference(FacilityReference facilityReference);
		@Override
		LoanLegalAction.LoanLegalActionBuilder addFacilityReference(FacilityReference facilityReference, int idx);
		@Override
		LoanLegalAction.LoanLegalActionBuilder addFacilityReference(List<? extends FacilityReference> facilityReference);
		@Override
		LoanLegalAction.LoanLegalActionBuilder setFacilityReference(List<? extends FacilityReference> facilityReference);
		LoanLegalAction.LoanLegalActionBuilder setApproval(ActionApproval approval);
		LoanLegalAction.LoanLegalActionBuilder setBefore(LoanLegalStructureBefore before);
		LoanLegalAction.LoanLegalActionBuilder setAfter(LoanLegalStructureAfter after);

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
			processRosetta(path.newSubPath("approval"), processor, ActionApproval.ActionApprovalBuilder.class, getApproval());
			processRosetta(path.newSubPath("before"), processor, LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder.class, getBefore());
			processRosetta(path.newSubPath("after"), processor, LoanLegalStructureAfter.LoanLegalStructureAfterBuilder.class, getAfter());
		}
		

		LoanLegalAction.LoanLegalActionBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalAction  ***********************/
	class LoanLegalActionImpl extends AbstractLoanLegalAction.AbstractLoanLegalActionImpl implements LoanLegalAction {
		private final ActionApproval approval;
		private final LoanLegalStructureBefore before;
		private final LoanLegalStructureAfter after;
		
		protected LoanLegalActionImpl(LoanLegalAction.LoanLegalActionBuilder builder) {
			super(builder);
			this.approval = ofNullable(builder.getApproval()).map(f->f.build()).orElse(null);
			this.before = ofNullable(builder.getBefore()).map(f->f.build()).orElse(null);
			this.after = ofNullable(builder.getAfter()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("approval")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("approval")
		public ActionApproval getApproval() {
			return approval;
		}
		
		@Override
		@RosettaAttribute("before")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("before")
		public LoanLegalStructureBefore getBefore() {
			return before;
		}
		
		@Override
		@RosettaAttribute("after")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("after")
		public LoanLegalStructureAfter getAfter() {
			return after;
		}
		
		@Override
		public LoanLegalAction build() {
			return this;
		}
		
		@Override
		public LoanLegalAction.LoanLegalActionBuilder toBuilder() {
			LoanLegalAction.LoanLegalActionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalAction.LoanLegalActionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getApproval()).ifPresent(builder::setApproval);
			ofNullable(getBefore()).ifPresent(builder::setBefore);
			ofNullable(getAfter()).ifPresent(builder::setAfter);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanLegalAction _that = getType().cast(o);
		
			if (!Objects.equals(approval, _that.getApproval())) return false;
			if (!Objects.equals(before, _that.getBefore())) return false;
			if (!Objects.equals(after, _that.getAfter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (approval != null ? approval.hashCode() : 0);
			_result = 31 * _result + (before != null ? before.hashCode() : 0);
			_result = 31 * _result + (after != null ? after.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalAction {" +
				"approval=" + this.approval + ", " +
				"before=" + this.before + ", " +
				"after=" + this.after +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanLegalAction  ***********************/
	class LoanLegalActionBuilderImpl extends AbstractLoanLegalAction.AbstractLoanLegalActionBuilderImpl implements LoanLegalAction.LoanLegalActionBuilder {
	
		protected ActionApproval.ActionApprovalBuilder approval;
		protected LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder before;
		protected LoanLegalStructureAfter.LoanLegalStructureAfterBuilder after;
		
		@Override
		@RosettaAttribute("approval")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("approval")
		public ActionApproval.ActionApprovalBuilder getApproval() {
			return approval;
		}
		
		@Override
		public ActionApproval.ActionApprovalBuilder getOrCreateApproval() {
			ActionApproval.ActionApprovalBuilder result;
			if (approval!=null) {
				result = approval;
			}
			else {
				result = approval = ActionApproval.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("before")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("before")
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder getBefore() {
			return before;
		}
		
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder getOrCreateBefore() {
			LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder result;
			if (before!=null) {
				result = before;
			}
			else {
				result = before = LoanLegalStructureBefore.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("after")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("after")
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder getAfter() {
			return after;
		}
		
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder getOrCreateAfter() {
			LoanLegalStructureAfter.LoanLegalStructureAfterBuilder result;
			if (after!=null) {
				result = after;
			}
			else {
				result = after = LoanLegalStructureAfter.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanLegalAction.LoanLegalActionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public LoanLegalAction.LoanLegalActionBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LoanLegalAction.LoanLegalActionBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legalActionId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legalActionId")
		@Override
		public LoanLegalAction.LoanLegalActionBuilder addLegalActionId(LegalActionId _legalActionId) {
			if (_legalActionId != null) {
				this.legalActionId.add(_legalActionId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalAction.LoanLegalActionBuilder addLegalActionId(LegalActionId _legalActionId, int idx) {
			getIndex(this.legalActionId, idx, () -> _legalActionId.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalAction.LoanLegalActionBuilder addLegalActionId(List<? extends LegalActionId> legalActionIds) {
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
		public LoanLegalAction.LoanLegalActionBuilder setLegalActionId(List<? extends LegalActionId> legalActionIds) {
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
		public LoanLegalAction.LoanLegalActionBuilder addVersionedLegalActionId(VersionedLegalActionId _versionedLegalActionId) {
			if (_versionedLegalActionId != null) {
				this.versionedLegalActionId.add(_versionedLegalActionId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalAction.LoanLegalActionBuilder addVersionedLegalActionId(VersionedLegalActionId _versionedLegalActionId, int idx) {
			getIndex(this.versionedLegalActionId, idx, () -> _versionedLegalActionId.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalAction.LoanLegalActionBuilder addVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionIds) {
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
		public LoanLegalAction.LoanLegalActionBuilder setVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionIds) {
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
		public LoanLegalAction.LoanLegalActionBuilder setActionDetails(LoanLegalActionDetails _actionDetails) {
			this.actionDetails = _actionDetails == null ? null : _actionDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public LoanLegalAction.LoanLegalActionBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public LoanLegalAction.LoanLegalActionBuilder addFacilityReference(FacilityReference _facilityReference) {
			if (_facilityReference != null) {
				this.facilityReference.add(_facilityReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalAction.LoanLegalActionBuilder addFacilityReference(FacilityReference _facilityReference, int idx) {
			getIndex(this.facilityReference, idx, () -> _facilityReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalAction.LoanLegalActionBuilder addFacilityReference(List<? extends FacilityReference> facilityReferences) {
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
		public LoanLegalAction.LoanLegalActionBuilder setFacilityReference(List<? extends FacilityReference> facilityReferences) {
			if (facilityReferences == null) {
				this.facilityReference = new ArrayList<>();
			} else {
				this.facilityReference = facilityReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("approval")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("approval")
		@Override
		public LoanLegalAction.LoanLegalActionBuilder setApproval(ActionApproval _approval) {
			this.approval = _approval == null ? null : _approval.toBuilder();
			return this;
		}
		
		@RosettaAttribute("before")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("before")
		@Override
		public LoanLegalAction.LoanLegalActionBuilder setBefore(LoanLegalStructureBefore _before) {
			this.before = _before == null ? null : _before.toBuilder();
			return this;
		}
		
		@RosettaAttribute("after")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("after")
		@Override
		public LoanLegalAction.LoanLegalActionBuilder setAfter(LoanLegalStructureAfter _after) {
			this.after = _after == null ? null : _after.toBuilder();
			return this;
		}
		
		@Override
		public LoanLegalAction build() {
			return new LoanLegalAction.LoanLegalActionImpl(this);
		}
		
		@Override
		public LoanLegalAction.LoanLegalActionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalAction.LoanLegalActionBuilder prune() {
			super.prune();
			if (approval!=null && !approval.prune().hasData()) approval = null;
			if (before!=null && !before.prune().hasData()) before = null;
			if (after!=null && !after.prune().hasData()) after = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getApproval()!=null && getApproval().hasData()) return true;
			if (getBefore()!=null && getBefore().hasData()) return true;
			if (getAfter()!=null && getAfter().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalAction.LoanLegalActionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanLegalAction.LoanLegalActionBuilder o = (LoanLegalAction.LoanLegalActionBuilder) other;
			
			merger.mergeRosetta(getApproval(), o.getApproval(), this::setApproval);
			merger.mergeRosetta(getBefore(), o.getBefore(), this::setBefore);
			merger.mergeRosetta(getAfter(), o.getAfter(), this::setAfter);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanLegalAction _that = getType().cast(o);
		
			if (!Objects.equals(approval, _that.getApproval())) return false;
			if (!Objects.equals(before, _that.getBefore())) return false;
			if (!Objects.equals(after, _that.getAfter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (approval != null ? approval.hashCode() : 0);
			_result = 31 * _result + (before != null ? before.hashCode() : 0);
			_result = 31 * _result + (after != null ? after.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionBuilder {" +
				"approval=" + this.approval + ", " +
				"before=" + this.before + ", " +
				"after=" + this.after +
			'}' + " " + super.toString();
		}
	}
}
