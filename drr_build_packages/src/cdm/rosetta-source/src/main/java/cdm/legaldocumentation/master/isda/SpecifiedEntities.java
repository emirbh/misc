package cdm.legaldocumentation.master.isda;

import cdm.legaldocumentation.common.SpecifiedEntityClauseEnum;
import cdm.legaldocumentation.master.isda.meta.SpecifiedEntitiesMeta;
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
 * A provision that allows each party to specify its Specified Entities for certain Events of Default and Termination Events.
 * @version 6.23.0
 */
@RosettaDataType(value="SpecifiedEntities", builder=SpecifiedEntities.SpecifiedEntitiesBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SpecifiedEntities", model="cdm", builder=SpecifiedEntities.SpecifiedEntitiesBuilderImpl.class, version="6.23.0")
public interface SpecifiedEntities extends RosettaModelObject {

	SpecifiedEntitiesMeta metaData = new SpecifiedEntitiesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Event of Default or Termination event for which Specified Entities terms are being defined.
	 */
	SpecifiedEntityClauseEnum getSpecifiedEntityClause();
	/**
	 * The party specific election of Specified Entities for the Event of Default or Termination Event specified.
	 */
	List<? extends SpecifiedEntity> getSpecifiedEntity();

	/*********************** Build Methods  ***********************/
	SpecifiedEntities build();
	
	SpecifiedEntities.SpecifiedEntitiesBuilder toBuilder();
	
	static SpecifiedEntities.SpecifiedEntitiesBuilder builder() {
		return new SpecifiedEntities.SpecifiedEntitiesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SpecifiedEntities> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SpecifiedEntities> getType() {
		return SpecifiedEntities.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("specifiedEntityClause"), SpecifiedEntityClauseEnum.class, getSpecifiedEntityClause(), this);
		processRosetta(path.newSubPath("specifiedEntity"), processor, SpecifiedEntity.class, getSpecifiedEntity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpecifiedEntitiesBuilder extends SpecifiedEntities, RosettaModelObjectBuilder {
		SpecifiedEntity.SpecifiedEntityBuilder getOrCreateSpecifiedEntity(int index);
		@Override
		List<? extends SpecifiedEntity.SpecifiedEntityBuilder> getSpecifiedEntity();
		SpecifiedEntities.SpecifiedEntitiesBuilder setSpecifiedEntityClause(SpecifiedEntityClauseEnum specifiedEntityClause);
		SpecifiedEntities.SpecifiedEntitiesBuilder addSpecifiedEntity(SpecifiedEntity specifiedEntity);
		SpecifiedEntities.SpecifiedEntitiesBuilder addSpecifiedEntity(SpecifiedEntity specifiedEntity, int idx);
		SpecifiedEntities.SpecifiedEntitiesBuilder addSpecifiedEntity(List<? extends SpecifiedEntity> specifiedEntity);
		SpecifiedEntities.SpecifiedEntitiesBuilder setSpecifiedEntity(List<? extends SpecifiedEntity> specifiedEntity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("specifiedEntityClause"), SpecifiedEntityClauseEnum.class, getSpecifiedEntityClause(), this);
			processRosetta(path.newSubPath("specifiedEntity"), processor, SpecifiedEntity.SpecifiedEntityBuilder.class, getSpecifiedEntity());
		}
		

		SpecifiedEntities.SpecifiedEntitiesBuilder prune();
	}

	/*********************** Immutable Implementation of SpecifiedEntities  ***********************/
	class SpecifiedEntitiesImpl implements SpecifiedEntities {
		private final SpecifiedEntityClauseEnum specifiedEntityClause;
		private final List<? extends SpecifiedEntity> specifiedEntity;
		
		protected SpecifiedEntitiesImpl(SpecifiedEntities.SpecifiedEntitiesBuilder builder) {
			this.specifiedEntityClause = builder.getSpecifiedEntityClause();
			this.specifiedEntity = ofNullable(builder.getSpecifiedEntity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("specifiedEntityClause")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("specifiedEntityClause")
		public SpecifiedEntityClauseEnum getSpecifiedEntityClause() {
			return specifiedEntityClause;
		}
		
		@Override
		@RosettaAttribute("specifiedEntity")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("specifiedEntity")
		public List<? extends SpecifiedEntity> getSpecifiedEntity() {
			return specifiedEntity;
		}
		
		@Override
		public SpecifiedEntities build() {
			return this;
		}
		
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder toBuilder() {
			SpecifiedEntities.SpecifiedEntitiesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpecifiedEntities.SpecifiedEntitiesBuilder builder) {
			ofNullable(getSpecifiedEntityClause()).ifPresent(builder::setSpecifiedEntityClause);
			ofNullable(getSpecifiedEntity()).ifPresent(builder::setSpecifiedEntity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecifiedEntities _that = getType().cast(o);
		
			if (!Objects.equals(specifiedEntityClause, _that.getSpecifiedEntityClause())) return false;
			if (!ListEquals.listEquals(specifiedEntity, _that.getSpecifiedEntity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (specifiedEntityClause != null ? specifiedEntityClause.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (specifiedEntity != null ? specifiedEntity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecifiedEntities {" +
				"specifiedEntityClause=" + this.specifiedEntityClause + ", " +
				"specifiedEntity=" + this.specifiedEntity +
			'}';
		}
	}

	/*********************** Builder Implementation of SpecifiedEntities  ***********************/
	class SpecifiedEntitiesBuilderImpl implements SpecifiedEntities.SpecifiedEntitiesBuilder {
	
		protected SpecifiedEntityClauseEnum specifiedEntityClause;
		protected List<SpecifiedEntity.SpecifiedEntityBuilder> specifiedEntity = new ArrayList<>();
		
		@Override
		@RosettaAttribute("specifiedEntityClause")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("specifiedEntityClause")
		public SpecifiedEntityClauseEnum getSpecifiedEntityClause() {
			return specifiedEntityClause;
		}
		
		@Override
		@RosettaAttribute("specifiedEntity")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("specifiedEntity")
		public List<? extends SpecifiedEntity.SpecifiedEntityBuilder> getSpecifiedEntity() {
			return specifiedEntity;
		}
		
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder getOrCreateSpecifiedEntity(int index) {
			if (specifiedEntity==null) {
				this.specifiedEntity = new ArrayList<>();
			}
			return getIndex(specifiedEntity, index, () -> {
						SpecifiedEntity.SpecifiedEntityBuilder newSpecifiedEntity = SpecifiedEntity.builder();
						return newSpecifiedEntity;
					});
		}
		
		@RosettaAttribute("specifiedEntityClause")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("specifiedEntityClause")
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder setSpecifiedEntityClause(SpecifiedEntityClauseEnum _specifiedEntityClause) {
			this.specifiedEntityClause = _specifiedEntityClause == null ? null : _specifiedEntityClause;
			return this;
		}
		
		@RosettaAttribute("specifiedEntity")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("specifiedEntity")
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder addSpecifiedEntity(SpecifiedEntity _specifiedEntity) {
			if (_specifiedEntity != null) {
				this.specifiedEntity.add(_specifiedEntity.toBuilder());
			}
			return this;
		}
		
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder addSpecifiedEntity(SpecifiedEntity _specifiedEntity, int idx) {
			getIndex(this.specifiedEntity, idx, () -> _specifiedEntity.toBuilder());
			return this;
		}
		
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder addSpecifiedEntity(List<? extends SpecifiedEntity> specifiedEntitys) {
			if (specifiedEntitys != null) {
				for (final SpecifiedEntity toAdd : specifiedEntitys) {
					this.specifiedEntity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("specifiedEntity")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("specifiedEntity")
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder setSpecifiedEntity(List<? extends SpecifiedEntity> specifiedEntitys) {
			if (specifiedEntitys == null) {
				this.specifiedEntity = new ArrayList<>();
			} else {
				this.specifiedEntity = specifiedEntitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SpecifiedEntities build() {
			return new SpecifiedEntities.SpecifiedEntitiesImpl(this);
		}
		
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder prune() {
			specifiedEntity = specifiedEntity.stream().filter(b->b!=null).<SpecifiedEntity.SpecifiedEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpecifiedEntityClause()!=null) return true;
			if (getSpecifiedEntity()!=null && getSpecifiedEntity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SpecifiedEntities.SpecifiedEntitiesBuilder o = (SpecifiedEntities.SpecifiedEntitiesBuilder) other;
			
			merger.mergeRosetta(getSpecifiedEntity(), o.getSpecifiedEntity(), this::getOrCreateSpecifiedEntity);
			
			merger.mergeBasic(getSpecifiedEntityClause(), o.getSpecifiedEntityClause(), this::setSpecifiedEntityClause);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecifiedEntities _that = getType().cast(o);
		
			if (!Objects.equals(specifiedEntityClause, _that.getSpecifiedEntityClause())) return false;
			if (!ListEquals.listEquals(specifiedEntity, _that.getSpecifiedEntity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (specifiedEntityClause != null ? specifiedEntityClause.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (specifiedEntity != null ? specifiedEntity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecifiedEntitiesBuilder {" +
				"specifiedEntityClause=" + this.specifiedEntityClause + ", " +
				"specifiedEntity=" + this.specifiedEntity +
			'}';
		}
	}
}
