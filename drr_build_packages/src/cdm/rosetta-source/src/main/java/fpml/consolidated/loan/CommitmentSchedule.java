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
import fpml.consolidated.loan.meta.CommitmentScheduleMeta;
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
 * Provision A structure that represents a complete amortization schedule through the life of a facility.
 *
 */
@RosettaDataType(value="CommitmentSchedule", builder=CommitmentSchedule.CommitmentScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommitmentSchedule", model="fpml", builder=CommitmentSchedule.CommitmentScheduleBuilderImpl.class, version="2.1.1")
public interface CommitmentSchedule extends RosettaModelObject {

	CommitmentScheduleMeta metaData = new CommitmentScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which a facility increase/decrease has/will occur.
	 *
	 */
	List<? extends CommitmentChange> getCommitmentChange();

	/*********************** Build Methods  ***********************/
	CommitmentSchedule build();
	
	CommitmentSchedule.CommitmentScheduleBuilder toBuilder();
	
	static CommitmentSchedule.CommitmentScheduleBuilder builder() {
		return new CommitmentSchedule.CommitmentScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommitmentSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommitmentSchedule> getType() {
		return CommitmentSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commitmentChange"), processor, CommitmentChange.class, getCommitmentChange());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommitmentScheduleBuilder extends CommitmentSchedule, RosettaModelObjectBuilder {
		CommitmentChange.CommitmentChangeBuilder getOrCreateCommitmentChange(int index);
		@Override
		List<? extends CommitmentChange.CommitmentChangeBuilder> getCommitmentChange();
		CommitmentSchedule.CommitmentScheduleBuilder addCommitmentChange(CommitmentChange commitmentChange);
		CommitmentSchedule.CommitmentScheduleBuilder addCommitmentChange(CommitmentChange commitmentChange, int idx);
		CommitmentSchedule.CommitmentScheduleBuilder addCommitmentChange(List<? extends CommitmentChange> commitmentChange);
		CommitmentSchedule.CommitmentScheduleBuilder setCommitmentChange(List<? extends CommitmentChange> commitmentChange);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commitmentChange"), processor, CommitmentChange.CommitmentChangeBuilder.class, getCommitmentChange());
		}
		

		CommitmentSchedule.CommitmentScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommitmentSchedule  ***********************/
	class CommitmentScheduleImpl implements CommitmentSchedule {
		private final List<? extends CommitmentChange> commitmentChange;
		
		protected CommitmentScheduleImpl(CommitmentSchedule.CommitmentScheduleBuilder builder) {
			this.commitmentChange = ofNullable(builder.getCommitmentChange()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commitmentChange")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("commitmentChange")
		public List<? extends CommitmentChange> getCommitmentChange() {
			return commitmentChange;
		}
		
		@Override
		public CommitmentSchedule build() {
			return this;
		}
		
		@Override
		public CommitmentSchedule.CommitmentScheduleBuilder toBuilder() {
			CommitmentSchedule.CommitmentScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommitmentSchedule.CommitmentScheduleBuilder builder) {
			ofNullable(getCommitmentChange()).ifPresent(builder::setCommitmentChange);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommitmentSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(commitmentChange, _that.getCommitmentChange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commitmentChange != null ? commitmentChange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommitmentSchedule {" +
				"commitmentChange=" + this.commitmentChange +
			'}';
		}
	}

	/*********************** Builder Implementation of CommitmentSchedule  ***********************/
	class CommitmentScheduleBuilderImpl implements CommitmentSchedule.CommitmentScheduleBuilder {
	
		protected List<CommitmentChange.CommitmentChangeBuilder> commitmentChange = new ArrayList<>();
		
		@Override
		@RosettaAttribute("commitmentChange")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("commitmentChange")
		public List<? extends CommitmentChange.CommitmentChangeBuilder> getCommitmentChange() {
			return commitmentChange;
		}
		
		@Override
		public CommitmentChange.CommitmentChangeBuilder getOrCreateCommitmentChange(int index) {
			if (commitmentChange==null) {
				this.commitmentChange = new ArrayList<>();
			}
			return getIndex(commitmentChange, index, () -> {
						CommitmentChange.CommitmentChangeBuilder newCommitmentChange = CommitmentChange.builder();
						return newCommitmentChange;
					});
		}
		
		@RosettaAttribute("commitmentChange")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("commitmentChange")
		@Override
		public CommitmentSchedule.CommitmentScheduleBuilder addCommitmentChange(CommitmentChange _commitmentChange) {
			if (_commitmentChange != null) {
				this.commitmentChange.add(_commitmentChange.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommitmentSchedule.CommitmentScheduleBuilder addCommitmentChange(CommitmentChange _commitmentChange, int idx) {
			getIndex(this.commitmentChange, idx, () -> _commitmentChange.toBuilder());
			return this;
		}
		
		@Override
		public CommitmentSchedule.CommitmentScheduleBuilder addCommitmentChange(List<? extends CommitmentChange> commitmentChanges) {
			if (commitmentChanges != null) {
				for (final CommitmentChange toAdd : commitmentChanges) {
					this.commitmentChange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("commitmentChange")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("commitmentChange")
		@Override
		public CommitmentSchedule.CommitmentScheduleBuilder setCommitmentChange(List<? extends CommitmentChange> commitmentChanges) {
			if (commitmentChanges == null) {
				this.commitmentChange = new ArrayList<>();
			} else {
				this.commitmentChange = commitmentChanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommitmentSchedule build() {
			return new CommitmentSchedule.CommitmentScheduleImpl(this);
		}
		
		@Override
		public CommitmentSchedule.CommitmentScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommitmentSchedule.CommitmentScheduleBuilder prune() {
			commitmentChange = commitmentChange.stream().filter(b->b!=null).<CommitmentChange.CommitmentChangeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommitmentChange()!=null && getCommitmentChange().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommitmentSchedule.CommitmentScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommitmentSchedule.CommitmentScheduleBuilder o = (CommitmentSchedule.CommitmentScheduleBuilder) other;
			
			merger.mergeRosetta(getCommitmentChange(), o.getCommitmentChange(), this::getOrCreateCommitmentChange);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommitmentSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(commitmentChange, _that.getCommitmentChange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commitmentChange != null ? commitmentChange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommitmentScheduleBuilder {" +
				"commitmentChange=" + this.commitmentChange +
			'}';
		}
	}
}
