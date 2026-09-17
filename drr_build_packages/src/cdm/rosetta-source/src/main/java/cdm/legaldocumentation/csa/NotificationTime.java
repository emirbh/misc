package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.NotificationTimeMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the time by which a demand for the Transfer of Eligible Credit Support (IM) or Posted Credit Support (IM) needs to be made in order for the transfer to take place in accordance with the Transfer Timing provisions.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(d)(iii)" * name "Notification Time"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(e)(iii)" * name "Notification Time"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(d)(iii)" * name "Notification Time"
 *
 * Provision 
 *
 */
@RosettaDataType(value="NotificationTime", builder=NotificationTime.NotificationTimeBuilderImpl.class, version="6.23.0")
@RuneDataType(value="NotificationTime", model="cdm", builder=NotificationTime.NotificationTimeBuilderImpl.class, version="6.23.0")
public interface NotificationTime extends RosettaModelObject {

	NotificationTimeMeta metaData = new NotificationTimeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parties&#39; Notification Time election.
	 */
	List<? extends NotificationTimeElection> getPartyElections();
	/**
	 * The determination of whether reference is made to dispute resolution notification timing in the agreement.
	 */
	Boolean getDisputeNotificationReference();
	/**
	 * The determination of whether transfer timing language is applicable or not.
	 */
	Boolean getTransferTimingProviso();

	/*********************** Build Methods  ***********************/
	NotificationTime build();
	
	NotificationTime.NotificationTimeBuilder toBuilder();
	
	static NotificationTime.NotificationTimeBuilder builder() {
		return new NotificationTime.NotificationTimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotificationTime> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotificationTime> getType() {
		return NotificationTime.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElections"), processor, NotificationTimeElection.class, getPartyElections());
		processor.processBasic(path.newSubPath("disputeNotificationReference"), Boolean.class, getDisputeNotificationReference(), this);
		processor.processBasic(path.newSubPath("transferTimingProviso"), Boolean.class, getTransferTimingProviso(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotificationTimeBuilder extends NotificationTime, RosettaModelObjectBuilder {
		NotificationTimeElection.NotificationTimeElectionBuilder getOrCreatePartyElections(int index);
		@Override
		List<? extends NotificationTimeElection.NotificationTimeElectionBuilder> getPartyElections();
		NotificationTime.NotificationTimeBuilder addPartyElections(NotificationTimeElection partyElections);
		NotificationTime.NotificationTimeBuilder addPartyElections(NotificationTimeElection partyElections, int idx);
		NotificationTime.NotificationTimeBuilder addPartyElections(List<? extends NotificationTimeElection> partyElections);
		NotificationTime.NotificationTimeBuilder setPartyElections(List<? extends NotificationTimeElection> partyElections);
		NotificationTime.NotificationTimeBuilder setDisputeNotificationReference(Boolean disputeNotificationReference);
		NotificationTime.NotificationTimeBuilder setTransferTimingProviso(Boolean transferTimingProviso);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElections"), processor, NotificationTimeElection.NotificationTimeElectionBuilder.class, getPartyElections());
			processor.processBasic(path.newSubPath("disputeNotificationReference"), Boolean.class, getDisputeNotificationReference(), this);
			processor.processBasic(path.newSubPath("transferTimingProviso"), Boolean.class, getTransferTimingProviso(), this);
		}
		

		NotificationTime.NotificationTimeBuilder prune();
	}

	/*********************** Immutable Implementation of NotificationTime  ***********************/
	class NotificationTimeImpl implements NotificationTime {
		private final List<? extends NotificationTimeElection> partyElections;
		private final Boolean disputeNotificationReference;
		private final Boolean transferTimingProviso;
		
		protected NotificationTimeImpl(NotificationTime.NotificationTimeBuilder builder) {
			this.partyElections = ofNullable(builder.getPartyElections()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.disputeNotificationReference = builder.getDisputeNotificationReference();
			this.transferTimingProviso = builder.getTransferTimingProviso();
		}
		
		@Override
		@RosettaAttribute("partyElections")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElections")
		public List<? extends NotificationTimeElection> getPartyElections() {
			return partyElections;
		}
		
		@Override
		@RosettaAttribute("disputeNotificationReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disputeNotificationReference")
		public Boolean getDisputeNotificationReference() {
			return disputeNotificationReference;
		}
		
		@Override
		@RosettaAttribute("transferTimingProviso")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferTimingProviso")
		public Boolean getTransferTimingProviso() {
			return transferTimingProviso;
		}
		
		@Override
		public NotificationTime build() {
			return this;
		}
		
		@Override
		public NotificationTime.NotificationTimeBuilder toBuilder() {
			NotificationTime.NotificationTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotificationTime.NotificationTimeBuilder builder) {
			ofNullable(getPartyElections()).ifPresent(builder::setPartyElections);
			ofNullable(getDisputeNotificationReference()).ifPresent(builder::setDisputeNotificationReference);
			ofNullable(getTransferTimingProviso()).ifPresent(builder::setTransferTimingProviso);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotificationTime _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElections, _that.getPartyElections())) return false;
			if (!Objects.equals(disputeNotificationReference, _that.getDisputeNotificationReference())) return false;
			if (!Objects.equals(transferTimingProviso, _that.getTransferTimingProviso())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElections != null ? partyElections.hashCode() : 0);
			_result = 31 * _result + (disputeNotificationReference != null ? disputeNotificationReference.hashCode() : 0);
			_result = 31 * _result + (transferTimingProviso != null ? transferTimingProviso.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotificationTime {" +
				"partyElections=" + this.partyElections + ", " +
				"disputeNotificationReference=" + this.disputeNotificationReference + ", " +
				"transferTimingProviso=" + this.transferTimingProviso +
			'}';
		}
	}

	/*********************** Builder Implementation of NotificationTime  ***********************/
	class NotificationTimeBuilderImpl implements NotificationTime.NotificationTimeBuilder {
	
		protected List<NotificationTimeElection.NotificationTimeElectionBuilder> partyElections = new ArrayList<>();
		protected Boolean disputeNotificationReference;
		protected Boolean transferTimingProviso;
		
		@Override
		@RosettaAttribute("partyElections")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElections")
		public List<? extends NotificationTimeElection.NotificationTimeElectionBuilder> getPartyElections() {
			return partyElections;
		}
		
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder getOrCreatePartyElections(int index) {
			if (partyElections==null) {
				this.partyElections = new ArrayList<>();
			}
			return getIndex(partyElections, index, () -> {
						NotificationTimeElection.NotificationTimeElectionBuilder newPartyElections = NotificationTimeElection.builder();
						return newPartyElections;
					});
		}
		
		@Override
		@RosettaAttribute("disputeNotificationReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disputeNotificationReference")
		public Boolean getDisputeNotificationReference() {
			return disputeNotificationReference;
		}
		
		@Override
		@RosettaAttribute("transferTimingProviso")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferTimingProviso")
		public Boolean getTransferTimingProviso() {
			return transferTimingProviso;
		}
		
		@RosettaAttribute("partyElections")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyElections")
		@Override
		public NotificationTime.NotificationTimeBuilder addPartyElections(NotificationTimeElection _partyElections) {
			if (_partyElections != null) {
				this.partyElections.add(_partyElections.toBuilder());
			}
			return this;
		}
		
		@Override
		public NotificationTime.NotificationTimeBuilder addPartyElections(NotificationTimeElection _partyElections, int idx) {
			getIndex(this.partyElections, idx, () -> _partyElections.toBuilder());
			return this;
		}
		
		@Override
		public NotificationTime.NotificationTimeBuilder addPartyElections(List<? extends NotificationTimeElection> partyElectionss) {
			if (partyElectionss != null) {
				for (final NotificationTimeElection toAdd : partyElectionss) {
					this.partyElections.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyElections")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("partyElections")
		@Override
		public NotificationTime.NotificationTimeBuilder setPartyElections(List<? extends NotificationTimeElection> partyElectionss) {
			if (partyElectionss == null) {
				this.partyElections = new ArrayList<>();
			} else {
				this.partyElections = partyElectionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("disputeNotificationReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("disputeNotificationReference")
		@Override
		public NotificationTime.NotificationTimeBuilder setDisputeNotificationReference(Boolean _disputeNotificationReference) {
			this.disputeNotificationReference = _disputeNotificationReference == null ? null : _disputeNotificationReference;
			return this;
		}
		
		@RosettaAttribute("transferTimingProviso")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transferTimingProviso")
		@Override
		public NotificationTime.NotificationTimeBuilder setTransferTimingProviso(Boolean _transferTimingProviso) {
			this.transferTimingProviso = _transferTimingProviso == null ? null : _transferTimingProviso;
			return this;
		}
		
		@Override
		public NotificationTime build() {
			return new NotificationTime.NotificationTimeImpl(this);
		}
		
		@Override
		public NotificationTime.NotificationTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotificationTime.NotificationTimeBuilder prune() {
			partyElections = partyElections.stream().filter(b->b!=null).<NotificationTimeElection.NotificationTimeElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElections()!=null && getPartyElections().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDisputeNotificationReference()!=null) return true;
			if (getTransferTimingProviso()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotificationTime.NotificationTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotificationTime.NotificationTimeBuilder o = (NotificationTime.NotificationTimeBuilder) other;
			
			merger.mergeRosetta(getPartyElections(), o.getPartyElections(), this::getOrCreatePartyElections);
			
			merger.mergeBasic(getDisputeNotificationReference(), o.getDisputeNotificationReference(), this::setDisputeNotificationReference);
			merger.mergeBasic(getTransferTimingProviso(), o.getTransferTimingProviso(), this::setTransferTimingProviso);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotificationTime _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElections, _that.getPartyElections())) return false;
			if (!Objects.equals(disputeNotificationReference, _that.getDisputeNotificationReference())) return false;
			if (!Objects.equals(transferTimingProviso, _that.getTransferTimingProviso())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElections != null ? partyElections.hashCode() : 0);
			_result = 31 * _result + (disputeNotificationReference != null ? disputeNotificationReference.hashCode() : 0);
			_result = 31 * _result + (transferTimingProviso != null ? transferTimingProviso.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotificationTimeBuilder {" +
				"partyElections=" + this.partyElections + ", " +
				"disputeNotificationReference=" + this.disputeNotificationReference + ", " +
				"transferTimingProviso=" + this.transferTimingProviso +
			'}';
		}
	}
}
