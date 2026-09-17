package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.ApprovalMeta;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PersonId;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A specific approval state in the workflow.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A specific approval state in the workflow.
 *
 */
@RosettaDataType(value="Approval", builder=Approval.ApprovalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Approval", model="fpml", builder=Approval.ApprovalBuilderImpl.class, version="2.1.1")
public interface Approval extends RosettaModelObject {

	ApprovalMeta metaData = new ApprovalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of approval (e.g. "pre-clearing credit").
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of approval (e.g. "pre-clearing credit").
	 *
	 */
	ApprovalType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The current state of approval (.e.g preapproved, pending approval, etc.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The current state of approval (.e.g preapproved, pending approval, etc.)
	 *
	 */
	String getStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The full name or identifiying ID of the relevant approver.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The full name or identifiying ID of the relevant approver.
	 *
	 */
	PersonId getApprover();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a party defined elsewhere in the document. The party referenced has approved the specified item (e.g. trade or allocation).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a party defined elsewhere in the document. The party referenced has approved the specified item (e.g. trade or allocation).
	 *
	 */
	PartyReference getApprovingPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a party defined elsewhere in the document. The party referenced was approved for the specified item (e.g. trade or allocation) by the approving party (if specified).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a party defined elsewhere in the document. The party referenced was approved for the specified item (e.g. trade or allocation) by the approving party (if specified).
	 *
	 */
	PartyReference getApprovedPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An identifer for a specific appoval, to allow the approval to be identified and tracked.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An identifer for a specific appoval, to allow the approval to be identified and tracked.
	 *
	 */
	ApprovalId getApprovalId();

	/*********************** Build Methods  ***********************/
	Approval build();
	
	Approval.ApprovalBuilder toBuilder();
	
	static Approval.ApprovalBuilder builder() {
		return new Approval.ApprovalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Approval> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Approval> getType() {
		return Approval.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("type"), processor, ApprovalType.class, _getType());
		processor.processBasic(path.newSubPath("status"), String.class, getStatus(), this);
		processRosetta(path.newSubPath("approver"), processor, PersonId.class, getApprover());
		processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.class, getApprovingPartyReference());
		processRosetta(path.newSubPath("approvedPartyReference"), processor, PartyReference.class, getApprovedPartyReference());
		processRosetta(path.newSubPath("approvalId"), processor, ApprovalId.class, getApprovalId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApprovalBuilder extends Approval, RosettaModelObjectBuilder {
		ApprovalType.ApprovalTypeBuilder getOrCreateType();
		@Override
		ApprovalType.ApprovalTypeBuilder _getType();
		PersonId.PersonIdBuilder getOrCreateApprover();
		@Override
		PersonId.PersonIdBuilder getApprover();
		PartyReference.PartyReferenceBuilder getOrCreateApprovingPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getApprovingPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateApprovedPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getApprovedPartyReference();
		ApprovalId.ApprovalIdBuilder getOrCreateApprovalId();
		@Override
		ApprovalId.ApprovalIdBuilder getApprovalId();
		Approval.ApprovalBuilder setType(ApprovalType type);
		Approval.ApprovalBuilder setStatus(String status);
		Approval.ApprovalBuilder setApprover(PersonId approver);
		Approval.ApprovalBuilder setApprovingPartyReference(PartyReference approvingPartyReference);
		Approval.ApprovalBuilder setApprovedPartyReference(PartyReference approvedPartyReference);
		Approval.ApprovalBuilder setApprovalId(ApprovalId approvalId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("type"), processor, ApprovalType.ApprovalTypeBuilder.class, _getType());
			processor.processBasic(path.newSubPath("status"), String.class, getStatus(), this);
			processRosetta(path.newSubPath("approver"), processor, PersonId.PersonIdBuilder.class, getApprover());
			processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getApprovingPartyReference());
			processRosetta(path.newSubPath("approvedPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getApprovedPartyReference());
			processRosetta(path.newSubPath("approvalId"), processor, ApprovalId.ApprovalIdBuilder.class, getApprovalId());
		}
		

		Approval.ApprovalBuilder prune();
	}

	/*********************** Immutable Implementation of Approval  ***********************/
	class ApprovalImpl implements Approval {
		private final ApprovalType type;
		private final String status;
		private final PersonId approver;
		private final PartyReference approvingPartyReference;
		private final PartyReference approvedPartyReference;
		private final ApprovalId approvalId;
		
		protected ApprovalImpl(Approval.ApprovalBuilder builder) {
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.status = builder.getStatus();
			this.approver = ofNullable(builder.getApprover()).map(f->f.build()).orElse(null);
			this.approvingPartyReference = ofNullable(builder.getApprovingPartyReference()).map(f->f.build()).orElse(null);
			this.approvedPartyReference = ofNullable(builder.getApprovedPartyReference()).map(f->f.build()).orElse(null);
			this.approvalId = ofNullable(builder.getApprovalId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public ApprovalType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("status")
		public String getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("approver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approver")
		public PersonId getApprover() {
			return approver;
		}
		
		@Override
		@RosettaAttribute("approvingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvingPartyReference")
		public PartyReference getApprovingPartyReference() {
			return approvingPartyReference;
		}
		
		@Override
		@RosettaAttribute("approvedPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvedPartyReference")
		public PartyReference getApprovedPartyReference() {
			return approvedPartyReference;
		}
		
		@Override
		@RosettaAttribute("approvalId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvalId")
		public ApprovalId getApprovalId() {
			return approvalId;
		}
		
		@Override
		public Approval build() {
			return this;
		}
		
		@Override
		public Approval.ApprovalBuilder toBuilder() {
			Approval.ApprovalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Approval.ApprovalBuilder builder) {
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getApprover()).ifPresent(builder::setApprover);
			ofNullable(getApprovingPartyReference()).ifPresent(builder::setApprovingPartyReference);
			ofNullable(getApprovedPartyReference()).ifPresent(builder::setApprovedPartyReference);
			ofNullable(getApprovalId()).ifPresent(builder::setApprovalId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Approval _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(approvedPartyReference, _that.getApprovedPartyReference())) return false;
			if (!Objects.equals(approvalId, _that.getApprovalId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (approvedPartyReference != null ? approvedPartyReference.hashCode() : 0);
			_result = 31 * _result + (approvalId != null ? approvalId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Approval {" +
				"type=" + this.type + ", " +
				"status=" + this.status + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"approvedPartyReference=" + this.approvedPartyReference + ", " +
				"approvalId=" + this.approvalId +
			'}';
		}
	}

	/*********************** Builder Implementation of Approval  ***********************/
	class ApprovalBuilderImpl implements Approval.ApprovalBuilder {
	
		protected ApprovalType.ApprovalTypeBuilder type;
		protected String status;
		protected PersonId.PersonIdBuilder approver;
		protected PartyReference.PartyReferenceBuilder approvingPartyReference;
		protected PartyReference.PartyReferenceBuilder approvedPartyReference;
		protected ApprovalId.ApprovalIdBuilder approvalId;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public ApprovalType.ApprovalTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public ApprovalType.ApprovalTypeBuilder getOrCreateType() {
			ApprovalType.ApprovalTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = ApprovalType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("status")
		public String getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("approver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approver")
		public PersonId.PersonIdBuilder getApprover() {
			return approver;
		}
		
		@Override
		public PersonId.PersonIdBuilder getOrCreateApprover() {
			PersonId.PersonIdBuilder result;
			if (approver!=null) {
				result = approver;
			}
			else {
				result = approver = PersonId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvingPartyReference")
		public PartyReference.PartyReferenceBuilder getApprovingPartyReference() {
			return approvingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateApprovingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (approvingPartyReference!=null) {
				result = approvingPartyReference;
			}
			else {
				result = approvingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvedPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvedPartyReference")
		public PartyReference.PartyReferenceBuilder getApprovedPartyReference() {
			return approvedPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateApprovedPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (approvedPartyReference!=null) {
				result = approvedPartyReference;
			}
			else {
				result = approvedPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvalId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvalId")
		public ApprovalId.ApprovalIdBuilder getApprovalId() {
			return approvalId;
		}
		
		@Override
		public ApprovalId.ApprovalIdBuilder getOrCreateApprovalId() {
			ApprovalId.ApprovalIdBuilder result;
			if (approvalId!=null) {
				result = approvalId;
			}
			else {
				result = approvalId = ApprovalId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public Approval.ApprovalBuilder setType(ApprovalType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("status")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("status")
		@Override
		public Approval.ApprovalBuilder setStatus(String _status) {
			this.status = _status == null ? null : _status;
			return this;
		}
		
		@RosettaAttribute("approver")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("approver")
		@Override
		public Approval.ApprovalBuilder setApprover(PersonId _approver) {
			this.approver = _approver == null ? null : _approver.toBuilder();
			return this;
		}
		
		@RosettaAttribute("approvingPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("approvingPartyReference")
		@Override
		public Approval.ApprovalBuilder setApprovingPartyReference(PartyReference _approvingPartyReference) {
			this.approvingPartyReference = _approvingPartyReference == null ? null : _approvingPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("approvedPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("approvedPartyReference")
		@Override
		public Approval.ApprovalBuilder setApprovedPartyReference(PartyReference _approvedPartyReference) {
			this.approvedPartyReference = _approvedPartyReference == null ? null : _approvedPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("approvalId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("approvalId")
		@Override
		public Approval.ApprovalBuilder setApprovalId(ApprovalId _approvalId) {
			this.approvalId = _approvalId == null ? null : _approvalId.toBuilder();
			return this;
		}
		
		@Override
		public Approval build() {
			return new Approval.ApprovalImpl(this);
		}
		
		@Override
		public Approval.ApprovalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Approval.ApprovalBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			if (approver!=null && !approver.prune().hasData()) approver = null;
			if (approvingPartyReference!=null && !approvingPartyReference.prune().hasData()) approvingPartyReference = null;
			if (approvedPartyReference!=null && !approvedPartyReference.prune().hasData()) approvedPartyReference = null;
			if (approvalId!=null && !approvalId.prune().hasData()) approvalId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (_getType()!=null && _getType().hasData()) return true;
			if (getStatus()!=null) return true;
			if (getApprover()!=null && getApprover().hasData()) return true;
			if (getApprovingPartyReference()!=null && getApprovingPartyReference().hasData()) return true;
			if (getApprovedPartyReference()!=null && getApprovedPartyReference().hasData()) return true;
			if (getApprovalId()!=null && getApprovalId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Approval.ApprovalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Approval.ApprovalBuilder o = (Approval.ApprovalBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			merger.mergeRosetta(getApprover(), o.getApprover(), this::setApprover);
			merger.mergeRosetta(getApprovingPartyReference(), o.getApprovingPartyReference(), this::setApprovingPartyReference);
			merger.mergeRosetta(getApprovedPartyReference(), o.getApprovedPartyReference(), this::setApprovedPartyReference);
			merger.mergeRosetta(getApprovalId(), o.getApprovalId(), this::setApprovalId);
			
			merger.mergeBasic(getStatus(), o.getStatus(), this::setStatus);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Approval _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(approvedPartyReference, _that.getApprovedPartyReference())) return false;
			if (!Objects.equals(approvalId, _that.getApprovalId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (approvedPartyReference != null ? approvedPartyReference.hashCode() : 0);
			_result = 31 * _result + (approvalId != null ? approvalId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalBuilder {" +
				"type=" + this.type + ", " +
				"status=" + this.status + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"approvedPartyReference=" + this.approvedPartyReference + ", " +
				"approvalId=" + this.approvalId +
			'}';
		}
	}
}
