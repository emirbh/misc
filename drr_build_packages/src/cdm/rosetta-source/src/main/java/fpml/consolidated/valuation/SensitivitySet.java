package fpml.consolidated.valuation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.riskdef.SensitivitySetDefinitionReference;
import fpml.consolidated.valuation.meta.SensitivitySetMeta;
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
 * version "recordkeeping-5.13"
 *
 * Provision A collection of sensitivities. References a definition that explains the meaning/type of the sensitivities.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A collection of sensitivities. References a definition that explains the meaning/type of the sensitivities.
 *
 */
@RosettaDataType(value="SensitivitySet", builder=SensitivitySet.SensitivitySetBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SensitivitySet", model="fpml", builder=SensitivitySet.SensitivitySetBuilderImpl.class, version="2.1.1")
public interface SensitivitySet extends RosettaModelObject {

	SensitivitySetMeta metaData = new SensitivitySetMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	String getId();
	/**
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
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to a sensitivity set definition.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to a sensitivity set definition.
	 *
	 */
	SensitivitySetDefinitionReference getDefinitionReference();
	/**
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
	List<? extends Sensitivity> getSensitivity();

	/*********************** Build Methods  ***********************/
	SensitivitySet build();
	
	SensitivitySet.SensitivitySetBuilder toBuilder();
	
	static SensitivitySet.SensitivitySetBuilder builder() {
		return new SensitivitySet.SensitivitySetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SensitivitySet> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SensitivitySet> getType() {
		return SensitivitySet.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("definitionReference"), processor, SensitivitySetDefinitionReference.class, getDefinitionReference());
		processRosetta(path.newSubPath("sensitivity"), processor, Sensitivity.class, getSensitivity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SensitivitySetBuilder extends SensitivitySet, RosettaModelObjectBuilder {
		SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder getOrCreateDefinitionReference();
		@Override
		SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder getDefinitionReference();
		Sensitivity.SensitivityBuilder getOrCreateSensitivity(int index);
		@Override
		List<? extends Sensitivity.SensitivityBuilder> getSensitivity();
		SensitivitySet.SensitivitySetBuilder setId(String id);
		SensitivitySet.SensitivitySetBuilder setName(String name);
		SensitivitySet.SensitivitySetBuilder setDefinitionReference(SensitivitySetDefinitionReference definitionReference);
		SensitivitySet.SensitivitySetBuilder addSensitivity(Sensitivity sensitivity);
		SensitivitySet.SensitivitySetBuilder addSensitivity(Sensitivity sensitivity, int idx);
		SensitivitySet.SensitivitySetBuilder addSensitivity(List<? extends Sensitivity> sensitivity);
		SensitivitySet.SensitivitySetBuilder setSensitivity(List<? extends Sensitivity> sensitivity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("definitionReference"), processor, SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder.class, getDefinitionReference());
			processRosetta(path.newSubPath("sensitivity"), processor, Sensitivity.SensitivityBuilder.class, getSensitivity());
		}
		

		SensitivitySet.SensitivitySetBuilder prune();
	}

	/*********************** Immutable Implementation of SensitivitySet  ***********************/
	class SensitivitySetImpl implements SensitivitySet {
		private final String id;
		private final String name;
		private final SensitivitySetDefinitionReference definitionReference;
		private final List<? extends Sensitivity> sensitivity;
		
		protected SensitivitySetImpl(SensitivitySet.SensitivitySetBuilder builder) {
			this.id = builder.getId();
			this.name = builder.getName();
			this.definitionReference = ofNullable(builder.getDefinitionReference()).map(f->f.build()).orElse(null);
			this.sensitivity = ofNullable(builder.getSensitivity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("definitionReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("definitionReference")
		public SensitivitySetDefinitionReference getDefinitionReference() {
			return definitionReference;
		}
		
		@Override
		@RosettaAttribute("sensitivity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sensitivity")
		public List<? extends Sensitivity> getSensitivity() {
			return sensitivity;
		}
		
		@Override
		public SensitivitySet build() {
			return this;
		}
		
		@Override
		public SensitivitySet.SensitivitySetBuilder toBuilder() {
			SensitivitySet.SensitivitySetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivitySet.SensitivitySetBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getDefinitionReference()).ifPresent(builder::setDefinitionReference);
			ofNullable(getSensitivity()).ifPresent(builder::setSensitivity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivitySet _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(definitionReference, _that.getDefinitionReference())) return false;
			if (!ListEquals.listEquals(sensitivity, _that.getSensitivity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (definitionReference != null ? definitionReference.hashCode() : 0);
			_result = 31 * _result + (sensitivity != null ? sensitivity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivitySet {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"definitionReference=" + this.definitionReference + ", " +
				"sensitivity=" + this.sensitivity +
			'}';
		}
	}

	/*********************** Builder Implementation of SensitivitySet  ***********************/
	class SensitivitySetBuilderImpl implements SensitivitySet.SensitivitySetBuilder {
	
		protected String id;
		protected String name;
		protected SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder definitionReference;
		protected List<Sensitivity.SensitivityBuilder> sensitivity = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("definitionReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("definitionReference")
		public SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder getDefinitionReference() {
			return definitionReference;
		}
		
		@Override
		public SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder getOrCreateDefinitionReference() {
			SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder result;
			if (definitionReference!=null) {
				result = definitionReference;
			}
			else {
				result = definitionReference = SensitivitySetDefinitionReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sensitivity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sensitivity")
		public List<? extends Sensitivity.SensitivityBuilder> getSensitivity() {
			return sensitivity;
		}
		
		@Override
		public Sensitivity.SensitivityBuilder getOrCreateSensitivity(int index) {
			if (sensitivity==null) {
				this.sensitivity = new ArrayList<>();
			}
			return getIndex(sensitivity, index, () -> {
						Sensitivity.SensitivityBuilder newSensitivity = Sensitivity.builder();
						return newSensitivity;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SensitivitySet.SensitivitySetBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public SensitivitySet.SensitivitySetBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("definitionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionReference")
		@Override
		public SensitivitySet.SensitivitySetBuilder setDefinitionReference(SensitivitySetDefinitionReference _definitionReference) {
			this.definitionReference = _definitionReference == null ? null : _definitionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sensitivity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("sensitivity")
		@Override
		public SensitivitySet.SensitivitySetBuilder addSensitivity(Sensitivity _sensitivity) {
			if (_sensitivity != null) {
				this.sensitivity.add(_sensitivity.toBuilder());
			}
			return this;
		}
		
		@Override
		public SensitivitySet.SensitivitySetBuilder addSensitivity(Sensitivity _sensitivity, int idx) {
			getIndex(this.sensitivity, idx, () -> _sensitivity.toBuilder());
			return this;
		}
		
		@Override
		public SensitivitySet.SensitivitySetBuilder addSensitivity(List<? extends Sensitivity> sensitivitys) {
			if (sensitivitys != null) {
				for (final Sensitivity toAdd : sensitivitys) {
					this.sensitivity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("sensitivity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("sensitivity")
		@Override
		public SensitivitySet.SensitivitySetBuilder setSensitivity(List<? extends Sensitivity> sensitivitys) {
			if (sensitivitys == null) {
				this.sensitivity = new ArrayList<>();
			} else {
				this.sensitivity = sensitivitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SensitivitySet build() {
			return new SensitivitySet.SensitivitySetImpl(this);
		}
		
		@Override
		public SensitivitySet.SensitivitySetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivitySet.SensitivitySetBuilder prune() {
			if (definitionReference!=null && !definitionReference.prune().hasData()) definitionReference = null;
			sensitivity = sensitivity.stream().filter(b->b!=null).<Sensitivity.SensitivityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getName()!=null) return true;
			if (getDefinitionReference()!=null && getDefinitionReference().hasData()) return true;
			if (getSensitivity()!=null && getSensitivity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivitySet.SensitivitySetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SensitivitySet.SensitivitySetBuilder o = (SensitivitySet.SensitivitySetBuilder) other;
			
			merger.mergeRosetta(getDefinitionReference(), o.getDefinitionReference(), this::setDefinitionReference);
			merger.mergeRosetta(getSensitivity(), o.getSensitivity(), this::getOrCreateSensitivity);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivitySet _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(definitionReference, _that.getDefinitionReference())) return false;
			if (!ListEquals.listEquals(sensitivity, _that.getSensitivity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (definitionReference != null ? definitionReference.hashCode() : 0);
			_result = 31 * _result + (sensitivity != null ? sensitivity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivitySetBuilder {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"definitionReference=" + this.definitionReference + ", " +
				"sensitivity=" + this.sensitivity +
			'}';
		}
	}
}
