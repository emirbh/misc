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
import fpml.consolidated.loan.meta.ParentTaskIdentifierMeta;
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
 * Provision A structure used to relate child tasks to one another.
 *
 */
@RosettaDataType(value="ParentTaskIdentifier", builder=ParentTaskIdentifier.ParentTaskIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ParentTaskIdentifier", model="fpml", builder=ParentTaskIdentifier.ParentTaskIdentifierBuilderImpl.class, version="2.1.1")
public interface ParentTaskIdentifier extends TaskIdentifier {

	ParentTaskIdentifierMeta metaData = new ParentTaskIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional array to express the unique identifiers of all underlying related child tasks.
	 *
	 */
	List<? extends TaskIdentifier> getChildTaskIdentifier();

	/*********************** Build Methods  ***********************/
	ParentTaskIdentifier build();
	
	ParentTaskIdentifier.ParentTaskIdentifierBuilder toBuilder();
	
	static ParentTaskIdentifier.ParentTaskIdentifierBuilder builder() {
		return new ParentTaskIdentifier.ParentTaskIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ParentTaskIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ParentTaskIdentifier> getType() {
		return ParentTaskIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("taskId"), processor, TaskId.class, getTaskId());
		processRosetta(path.newSubPath("versionedTaskId"), processor, VersionedTaskId.class, getVersionedTaskId());
		processRosetta(path.newSubPath("childTaskIdentifier"), processor, TaskIdentifier.class, getChildTaskIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ParentTaskIdentifierBuilder extends ParentTaskIdentifier, TaskIdentifier.TaskIdentifierBuilder {
		TaskIdentifier.TaskIdentifierBuilder getOrCreateChildTaskIdentifier(int index);
		@Override
		List<? extends TaskIdentifier.TaskIdentifierBuilder> getChildTaskIdentifier();
		@Override
		ParentTaskIdentifier.ParentTaskIdentifierBuilder setId(String id);
		@Override
		ParentTaskIdentifier.ParentTaskIdentifierBuilder setPartyReference(PartyReference partyReference);
		@Override
		ParentTaskIdentifier.ParentTaskIdentifierBuilder setTaskId(TaskId taskId);
		@Override
		ParentTaskIdentifier.ParentTaskIdentifierBuilder setVersionedTaskId(VersionedTaskId versionedTaskId);
		ParentTaskIdentifier.ParentTaskIdentifierBuilder addChildTaskIdentifier(TaskIdentifier childTaskIdentifier);
		ParentTaskIdentifier.ParentTaskIdentifierBuilder addChildTaskIdentifier(TaskIdentifier childTaskIdentifier, int idx);
		ParentTaskIdentifier.ParentTaskIdentifierBuilder addChildTaskIdentifier(List<? extends TaskIdentifier> childTaskIdentifier);
		ParentTaskIdentifier.ParentTaskIdentifierBuilder setChildTaskIdentifier(List<? extends TaskIdentifier> childTaskIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("taskId"), processor, TaskId.TaskIdBuilder.class, getTaskId());
			processRosetta(path.newSubPath("versionedTaskId"), processor, VersionedTaskId.VersionedTaskIdBuilder.class, getVersionedTaskId());
			processRosetta(path.newSubPath("childTaskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getChildTaskIdentifier());
		}
		

		ParentTaskIdentifier.ParentTaskIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of ParentTaskIdentifier  ***********************/
	class ParentTaskIdentifierImpl extends TaskIdentifier.TaskIdentifierImpl implements ParentTaskIdentifier {
		private final List<? extends TaskIdentifier> childTaskIdentifier;
		
		protected ParentTaskIdentifierImpl(ParentTaskIdentifier.ParentTaskIdentifierBuilder builder) {
			super(builder);
			this.childTaskIdentifier = ofNullable(builder.getChildTaskIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("childTaskIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("childTaskIdentifier")
		public List<? extends TaskIdentifier> getChildTaskIdentifier() {
			return childTaskIdentifier;
		}
		
		@Override
		public ParentTaskIdentifier build() {
			return this;
		}
		
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder toBuilder() {
			ParentTaskIdentifier.ParentTaskIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ParentTaskIdentifier.ParentTaskIdentifierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getChildTaskIdentifier()).ifPresent(builder::setChildTaskIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ParentTaskIdentifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(childTaskIdentifier, _that.getChildTaskIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (childTaskIdentifier != null ? childTaskIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParentTaskIdentifier {" +
				"childTaskIdentifier=" + this.childTaskIdentifier +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ParentTaskIdentifier  ***********************/
	class ParentTaskIdentifierBuilderImpl extends TaskIdentifier.TaskIdentifierBuilderImpl implements ParentTaskIdentifier.ParentTaskIdentifierBuilder {
	
		protected List<TaskIdentifier.TaskIdentifierBuilder> childTaskIdentifier = new ArrayList<>();
		
		@Override
		@RosettaAttribute("childTaskIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("childTaskIdentifier")
		public List<? extends TaskIdentifier.TaskIdentifierBuilder> getChildTaskIdentifier() {
			return childTaskIdentifier;
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder getOrCreateChildTaskIdentifier(int index) {
			if (childTaskIdentifier==null) {
				this.childTaskIdentifier = new ArrayList<>();
			}
			return getIndex(childTaskIdentifier, index, () -> {
						TaskIdentifier.TaskIdentifierBuilder newChildTaskIdentifier = TaskIdentifier.builder();
						return newChildTaskIdentifier;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("taskId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("taskId")
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder setTaskId(TaskId _taskId) {
			this.taskId = _taskId == null ? null : _taskId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("versionedTaskId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("versionedTaskId")
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder setVersionedTaskId(VersionedTaskId _versionedTaskId) {
			this.versionedTaskId = _versionedTaskId == null ? null : _versionedTaskId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("childTaskIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("childTaskIdentifier")
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder addChildTaskIdentifier(TaskIdentifier _childTaskIdentifier) {
			if (_childTaskIdentifier != null) {
				this.childTaskIdentifier.add(_childTaskIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder addChildTaskIdentifier(TaskIdentifier _childTaskIdentifier, int idx) {
			getIndex(this.childTaskIdentifier, idx, () -> _childTaskIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder addChildTaskIdentifier(List<? extends TaskIdentifier> childTaskIdentifiers) {
			if (childTaskIdentifiers != null) {
				for (final TaskIdentifier toAdd : childTaskIdentifiers) {
					this.childTaskIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("childTaskIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("childTaskIdentifier")
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder setChildTaskIdentifier(List<? extends TaskIdentifier> childTaskIdentifiers) {
			if (childTaskIdentifiers == null) {
				this.childTaskIdentifier = new ArrayList<>();
			} else {
				this.childTaskIdentifier = childTaskIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ParentTaskIdentifier build() {
			return new ParentTaskIdentifier.ParentTaskIdentifierImpl(this);
		}
		
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder prune() {
			super.prune();
			childTaskIdentifier = childTaskIdentifier.stream().filter(b->b!=null).<TaskIdentifier.TaskIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getChildTaskIdentifier()!=null && getChildTaskIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParentTaskIdentifier.ParentTaskIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ParentTaskIdentifier.ParentTaskIdentifierBuilder o = (ParentTaskIdentifier.ParentTaskIdentifierBuilder) other;
			
			merger.mergeRosetta(getChildTaskIdentifier(), o.getChildTaskIdentifier(), this::getOrCreateChildTaskIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ParentTaskIdentifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(childTaskIdentifier, _that.getChildTaskIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (childTaskIdentifier != null ? childTaskIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParentTaskIdentifierBuilder {" +
				"childTaskIdentifier=" + this.childTaskIdentifier +
			'}' + " " + super.toString();
		}
	}
}
