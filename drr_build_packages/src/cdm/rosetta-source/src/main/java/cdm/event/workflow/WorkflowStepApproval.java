package cdm.event.workflow;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.workflow.meta.WorkflowStepApprovalMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Party approvals associated to the current WorkflowStep. 
 * @version 6.23.0
 */
@RosettaDataType(value="WorkflowStepApproval", builder=WorkflowStepApproval.WorkflowStepApprovalBuilderImpl.class, version="6.23.0")
@RuneDataType(value="WorkflowStepApproval", model="cdm", builder=WorkflowStepApproval.WorkflowStepApprovalBuilderImpl.class, version="6.23.0")
public interface WorkflowStepApproval extends RosettaModelObject, GlobalKey {

	WorkflowStepApprovalMeta metaData = new WorkflowStepApprovalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Flag denoting whether the workflow step is approved or not
	 */
	Boolean getApproved();
	/**
	 * Reference to the Party who is approving/rejecting this workflow step
	 */
	ReferenceWithMetaParty getParty();
	/**
	 * Optional reason for rejecting the workflow step
	 */
	String getRejectedReason();
	/**
	 * Timestamp of the approval
	 */
	EventTimestamp getTimestamp();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	WorkflowStepApproval build();
	
	WorkflowStepApproval.WorkflowStepApprovalBuilder toBuilder();
	
	static WorkflowStepApproval.WorkflowStepApprovalBuilder builder() {
		return new WorkflowStepApproval.WorkflowStepApprovalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WorkflowStepApproval> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WorkflowStepApproval> getType() {
		return WorkflowStepApproval.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("approved"), Boolean.class, getApproved(), this);
		processRosetta(path.newSubPath("party"), processor, ReferenceWithMetaParty.class, getParty());
		processor.processBasic(path.newSubPath("rejectedReason"), String.class, getRejectedReason(), this);
		processRosetta(path.newSubPath("timestamp"), processor, EventTimestamp.class, getTimestamp());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WorkflowStepApprovalBuilder extends WorkflowStepApproval, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateParty();
		@Override
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getParty();
		EventTimestamp.EventTimestampBuilder getOrCreateTimestamp();
		@Override
		EventTimestamp.EventTimestampBuilder getTimestamp();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		WorkflowStepApproval.WorkflowStepApprovalBuilder setApproved(Boolean approved);
		WorkflowStepApproval.WorkflowStepApprovalBuilder setParty(ReferenceWithMetaParty party);
		WorkflowStepApproval.WorkflowStepApprovalBuilder setPartyValue(Party party);
		WorkflowStepApproval.WorkflowStepApprovalBuilder setRejectedReason(String rejectedReason);
		WorkflowStepApproval.WorkflowStepApprovalBuilder setTimestamp(EventTimestamp timestamp);
		WorkflowStepApproval.WorkflowStepApprovalBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("approved"), Boolean.class, getApproved(), this);
			processRosetta(path.newSubPath("party"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getParty());
			processor.processBasic(path.newSubPath("rejectedReason"), String.class, getRejectedReason(), this);
			processRosetta(path.newSubPath("timestamp"), processor, EventTimestamp.EventTimestampBuilder.class, getTimestamp());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		WorkflowStepApproval.WorkflowStepApprovalBuilder prune();
	}

	/*********************** Immutable Implementation of WorkflowStepApproval  ***********************/
	class WorkflowStepApprovalImpl implements WorkflowStepApproval {
		private final Boolean approved;
		private final ReferenceWithMetaParty party;
		private final String rejectedReason;
		private final EventTimestamp timestamp;
		private final MetaFields meta;
		
		protected WorkflowStepApprovalImpl(WorkflowStepApproval.WorkflowStepApprovalBuilder builder) {
			this.approved = builder.getApproved();
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
			this.rejectedReason = builder.getRejectedReason();
			this.timestamp = ofNullable(builder.getTimestamp()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("approved")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("approved")
		public Boolean getApproved() {
			return approved;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public ReferenceWithMetaParty getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("rejectedReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rejectedReason")
		public String getRejectedReason() {
			return rejectedReason;
		}
		
		@Override
		@RosettaAttribute("timestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("timestamp")
		public EventTimestamp getTimestamp() {
			return timestamp;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public WorkflowStepApproval build() {
			return this;
		}
		
		@Override
		public WorkflowStepApproval.WorkflowStepApprovalBuilder toBuilder() {
			WorkflowStepApproval.WorkflowStepApprovalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WorkflowStepApproval.WorkflowStepApprovalBuilder builder) {
			ofNullable(getApproved()).ifPresent(builder::setApproved);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getRejectedReason()).ifPresent(builder::setRejectedReason);
			ofNullable(getTimestamp()).ifPresent(builder::setTimestamp);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WorkflowStepApproval _that = getType().cast(o);
		
			if (!Objects.equals(approved, _that.getApproved())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(rejectedReason, _that.getRejectedReason())) return false;
			if (!Objects.equals(timestamp, _that.getTimestamp())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (approved != null ? approved.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (rejectedReason != null ? rejectedReason.hashCode() : 0);
			_result = 31 * _result + (timestamp != null ? timestamp.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WorkflowStepApproval {" +
				"approved=" + this.approved + ", " +
				"party=" + this.party + ", " +
				"rejectedReason=" + this.rejectedReason + ", " +
				"timestamp=" + this.timestamp + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of WorkflowStepApproval  ***********************/
	class WorkflowStepApprovalBuilderImpl implements WorkflowStepApproval.WorkflowStepApprovalBuilder {
	
		protected Boolean approved;
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder party;
		protected String rejectedReason;
		protected EventTimestamp.EventTimestampBuilder timestamp;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("approved")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("approved")
		public Boolean getApproved() {
			return approved;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getParty() {
			return party;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateParty() {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder result;
			if (party!=null) {
				result = party;
			}
			else {
				result = party = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rejectedReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rejectedReason")
		public String getRejectedReason() {
			return rejectedReason;
		}
		
		@Override
		@RosettaAttribute("timestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("timestamp")
		public EventTimestamp.EventTimestampBuilder getTimestamp() {
			return timestamp;
		}
		
		@Override
		public EventTimestamp.EventTimestampBuilder getOrCreateTimestamp() {
			EventTimestamp.EventTimestampBuilder result;
			if (timestamp!=null) {
				result = timestamp;
			}
			else {
				result = timestamp = EventTimestamp.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("approved")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("approved")
		@Override
		public WorkflowStepApproval.WorkflowStepApprovalBuilder setApproved(Boolean _approved) {
			this.approved = _approved == null ? null : _approved;
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public WorkflowStepApproval.WorkflowStepApprovalBuilder setParty(ReferenceWithMetaParty _party) {
			this.party = _party == null ? null : _party.toBuilder();
			return this;
		}
		
		@Override
		public WorkflowStepApproval.WorkflowStepApprovalBuilder setPartyValue(Party _party) {
			this.getOrCreateParty().setValue(_party);
			return this;
		}
		
		@RosettaAttribute("rejectedReason")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rejectedReason")
		@Override
		public WorkflowStepApproval.WorkflowStepApprovalBuilder setRejectedReason(String _rejectedReason) {
			this.rejectedReason = _rejectedReason == null ? null : _rejectedReason;
			return this;
		}
		
		@RosettaAttribute("timestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("timestamp")
		@Override
		public WorkflowStepApproval.WorkflowStepApprovalBuilder setTimestamp(EventTimestamp _timestamp) {
			this.timestamp = _timestamp == null ? null : _timestamp.toBuilder();
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public WorkflowStepApproval.WorkflowStepApprovalBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public WorkflowStepApproval build() {
			return new WorkflowStepApproval.WorkflowStepApprovalImpl(this);
		}
		
		@Override
		public WorkflowStepApproval.WorkflowStepApprovalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WorkflowStepApproval.WorkflowStepApprovalBuilder prune() {
			if (party!=null && !party.prune().hasData()) party = null;
			if (timestamp!=null && !timestamp.prune().hasData()) timestamp = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApproved()!=null) return true;
			if (getParty()!=null && getParty().hasData()) return true;
			if (getRejectedReason()!=null) return true;
			if (getTimestamp()!=null && getTimestamp().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WorkflowStepApproval.WorkflowStepApprovalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WorkflowStepApproval.WorkflowStepApprovalBuilder o = (WorkflowStepApproval.WorkflowStepApprovalBuilder) other;
			
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			merger.mergeRosetta(getTimestamp(), o.getTimestamp(), this::setTimestamp);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getApproved(), o.getApproved(), this::setApproved);
			merger.mergeBasic(getRejectedReason(), o.getRejectedReason(), this::setRejectedReason);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WorkflowStepApproval _that = getType().cast(o);
		
			if (!Objects.equals(approved, _that.getApproved())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(rejectedReason, _that.getRejectedReason())) return false;
			if (!Objects.equals(timestamp, _that.getTimestamp())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (approved != null ? approved.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (rejectedReason != null ? rejectedReason.hashCode() : 0);
			_result = 31 * _result + (timestamp != null ? timestamp.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WorkflowStepApprovalBuilder {" +
				"approved=" + this.approved + ", " +
				"party=" + this.party + ", " +
				"rejectedReason=" + this.rejectedReason + ", " +
				"timestamp=" + this.timestamp + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
