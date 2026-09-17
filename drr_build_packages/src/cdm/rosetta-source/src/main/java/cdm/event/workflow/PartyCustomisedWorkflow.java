package cdm.event.workflow;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.workflow.meta.PartyCustomisedWorkflowMeta;
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
 * A class to specify a party-related, non-standardized data in a generic form.
 * @version 6.23.0
 */
@RosettaDataType(value="PartyCustomisedWorkflow", builder=PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilderImpl.class, version="6.23.0")
@RuneDataType(value="PartyCustomisedWorkflow", model="cdm", builder=PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilderImpl.class, version="6.23.0")
public interface PartyCustomisedWorkflow extends RosettaModelObject {

	PartyCustomisedWorkflowMeta metaData = new PartyCustomisedWorkflowMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to the party to which the workflow pertains to.
	 */
	ReferenceWithMetaParty getPartyReference();
	/**
	 * The party name to which the workflow pertains to.
	 */
	String getPartyName();
	/**
	 * Non-standardized data in a generic form.
	 */
	List<? extends CustomisedWorkflow> getCustomisedWorkflow();

	/*********************** Build Methods  ***********************/
	PartyCustomisedWorkflow build();
	
	PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder toBuilder();
	
	static PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder builder() {
		return new PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyCustomisedWorkflow> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyCustomisedWorkflow> getType() {
		return PartyCustomisedWorkflow.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
		processor.processBasic(path.newSubPath("partyName"), String.class, getPartyName(), this);
		processRosetta(path.newSubPath("customisedWorkflow"), processor, CustomisedWorkflow.class, getCustomisedWorkflow());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyCustomisedWorkflowBuilder extends PartyCustomisedWorkflow, RosettaModelObjectBuilder {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePartyReference();
		@Override
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getPartyReference();
		CustomisedWorkflow.CustomisedWorkflowBuilder getOrCreateCustomisedWorkflow(int index);
		@Override
		List<? extends CustomisedWorkflow.CustomisedWorkflowBuilder> getCustomisedWorkflow();
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setPartyReference(ReferenceWithMetaParty partyReference);
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setPartyReferenceValue(Party partyReference);
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setPartyName(String partyName);
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder addCustomisedWorkflow(CustomisedWorkflow customisedWorkflow);
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder addCustomisedWorkflow(CustomisedWorkflow customisedWorkflow, int idx);
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder addCustomisedWorkflow(List<? extends CustomisedWorkflow> customisedWorkflow);
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setCustomisedWorkflow(List<? extends CustomisedWorkflow> customisedWorkflow);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getPartyReference());
			processor.processBasic(path.newSubPath("partyName"), String.class, getPartyName(), this);
			processRosetta(path.newSubPath("customisedWorkflow"), processor, CustomisedWorkflow.CustomisedWorkflowBuilder.class, getCustomisedWorkflow());
		}
		

		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder prune();
	}

	/*********************** Immutable Implementation of PartyCustomisedWorkflow  ***********************/
	class PartyCustomisedWorkflowImpl implements PartyCustomisedWorkflow {
		private final ReferenceWithMetaParty partyReference;
		private final String partyName;
		private final List<? extends CustomisedWorkflow> customisedWorkflow;
		
		protected PartyCustomisedWorkflowImpl(PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.partyName = builder.getPartyName();
			this.customisedWorkflow = ofNullable(builder.getCustomisedWorkflow()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyReference")
		public ReferenceWithMetaParty getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("partyName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyName")
		public String getPartyName() {
			return partyName;
		}
		
		@Override
		@RosettaAttribute("customisedWorkflow")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("customisedWorkflow")
		public List<? extends CustomisedWorkflow> getCustomisedWorkflow() {
			return customisedWorkflow;
		}
		
		@Override
		public PartyCustomisedWorkflow build() {
			return this;
		}
		
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder toBuilder() {
			PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getPartyName()).ifPresent(builder::setPartyName);
			ofNullable(getCustomisedWorkflow()).ifPresent(builder::setCustomisedWorkflow);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyCustomisedWorkflow _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(partyName, _that.getPartyName())) return false;
			if (!ListEquals.listEquals(customisedWorkflow, _that.getCustomisedWorkflow())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (partyName != null ? partyName.hashCode() : 0);
			_result = 31 * _result + (customisedWorkflow != null ? customisedWorkflow.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyCustomisedWorkflow {" +
				"partyReference=" + this.partyReference + ", " +
				"partyName=" + this.partyName + ", " +
				"customisedWorkflow=" + this.customisedWorkflow +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyCustomisedWorkflow  ***********************/
	class PartyCustomisedWorkflowBuilderImpl implements PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder {
	
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference;
		protected String partyName;
		protected List<CustomisedWorkflow.CustomisedWorkflowBuilder> customisedWorkflow = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyReference")
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePartyReference() {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyName")
		public String getPartyName() {
			return partyName;
		}
		
		@Override
		@RosettaAttribute("customisedWorkflow")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("customisedWorkflow")
		public List<? extends CustomisedWorkflow.CustomisedWorkflowBuilder> getCustomisedWorkflow() {
			return customisedWorkflow;
		}
		
		@Override
		public CustomisedWorkflow.CustomisedWorkflowBuilder getOrCreateCustomisedWorkflow(int index) {
			if (customisedWorkflow==null) {
				this.customisedWorkflow = new ArrayList<>();
			}
			return getIndex(customisedWorkflow, index, () -> {
						CustomisedWorkflow.CustomisedWorkflowBuilder newCustomisedWorkflow = CustomisedWorkflow.builder();
						return newCustomisedWorkflow;
					});
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setPartyReference(ReferenceWithMetaParty _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setPartyReferenceValue(Party _partyReference) {
			this.getOrCreatePartyReference().setValue(_partyReference);
			return this;
		}
		
		@RosettaAttribute("partyName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyName")
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setPartyName(String _partyName) {
			this.partyName = _partyName == null ? null : _partyName;
			return this;
		}
		
		@RosettaAttribute("customisedWorkflow")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("customisedWorkflow")
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder addCustomisedWorkflow(CustomisedWorkflow _customisedWorkflow) {
			if (_customisedWorkflow != null) {
				this.customisedWorkflow.add(_customisedWorkflow.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder addCustomisedWorkflow(CustomisedWorkflow _customisedWorkflow, int idx) {
			getIndex(this.customisedWorkflow, idx, () -> _customisedWorkflow.toBuilder());
			return this;
		}
		
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder addCustomisedWorkflow(List<? extends CustomisedWorkflow> customisedWorkflows) {
			if (customisedWorkflows != null) {
				for (final CustomisedWorkflow toAdd : customisedWorkflows) {
					this.customisedWorkflow.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("customisedWorkflow")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("customisedWorkflow")
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setCustomisedWorkflow(List<? extends CustomisedWorkflow> customisedWorkflows) {
			if (customisedWorkflows == null) {
				this.customisedWorkflow = new ArrayList<>();
			} else {
				this.customisedWorkflow = customisedWorkflows.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyCustomisedWorkflow build() {
			return new PartyCustomisedWorkflow.PartyCustomisedWorkflowImpl(this);
		}
		
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			customisedWorkflow = customisedWorkflow.stream().filter(b->b!=null).<CustomisedWorkflow.CustomisedWorkflowBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getPartyName()!=null) return true;
			if (getCustomisedWorkflow()!=null && getCustomisedWorkflow().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder o = (PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getCustomisedWorkflow(), o.getCustomisedWorkflow(), this::getOrCreateCustomisedWorkflow);
			
			merger.mergeBasic(getPartyName(), o.getPartyName(), this::setPartyName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyCustomisedWorkflow _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(partyName, _that.getPartyName())) return false;
			if (!ListEquals.listEquals(customisedWorkflow, _that.getCustomisedWorkflow())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (partyName != null ? partyName.hashCode() : 0);
			_result = 31 * _result + (customisedWorkflow != null ? customisedWorkflow.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyCustomisedWorkflowBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"partyName=" + this.partyName + ", " +
				"customisedWorkflow=" + this.customisedWorkflow +
			'}';
		}
	}
}
