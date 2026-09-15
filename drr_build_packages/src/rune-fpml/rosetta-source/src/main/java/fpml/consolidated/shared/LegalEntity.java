package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.LegalEntityMeta;
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
 * Provision A type defining a legal entity.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a legal entity.
 *
 */
@RosettaDataType(value="LegalEntity", builder=LegalEntity.LegalEntityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LegalEntity", model="fpml", builder=LegalEntity.LegalEntityBuilderImpl.class, version="2.1.1")
public interface LegalEntity extends RosettaModelObject {

	LegalEntityMeta metaData = new LegalEntityMeta();

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
	 * Provision The name of the reference entity. A free format string. FpML does not define usage rules for this element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the reference entity. A free format string. FpML does not define usage rules for this element.
	 *
	 */
	EntityName getEntityName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A legal entity identifier (e.g. RED entity code).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A legal entity identifier (e.g. RED entity code).
	 *
	 */
	List<? extends EntityId> getEntityId();

	/*********************** Build Methods  ***********************/
	LegalEntity build();
	
	LegalEntity.LegalEntityBuilder toBuilder();
	
	static LegalEntity.LegalEntityBuilder builder() {
		return new LegalEntity.LegalEntityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegalEntity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegalEntity> getType() {
		return LegalEntity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("entityName"), processor, EntityName.class, getEntityName());
		processRosetta(path.newSubPath("entityId"), processor, EntityId.class, getEntityId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegalEntityBuilder extends LegalEntity, RosettaModelObjectBuilder {
		EntityName.EntityNameBuilder getOrCreateEntityName();
		@Override
		EntityName.EntityNameBuilder getEntityName();
		EntityId.EntityIdBuilder getOrCreateEntityId(int index);
		@Override
		List<? extends EntityId.EntityIdBuilder> getEntityId();
		LegalEntity.LegalEntityBuilder setId(String id);
		LegalEntity.LegalEntityBuilder setEntityName(EntityName entityName);
		LegalEntity.LegalEntityBuilder addEntityId(EntityId entityId);
		LegalEntity.LegalEntityBuilder addEntityId(EntityId entityId, int idx);
		LegalEntity.LegalEntityBuilder addEntityId(List<? extends EntityId> entityId);
		LegalEntity.LegalEntityBuilder setEntityId(List<? extends EntityId> entityId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("entityName"), processor, EntityName.EntityNameBuilder.class, getEntityName());
			processRosetta(path.newSubPath("entityId"), processor, EntityId.EntityIdBuilder.class, getEntityId());
		}
		

		LegalEntity.LegalEntityBuilder prune();
	}

	/*********************** Immutable Implementation of LegalEntity  ***********************/
	class LegalEntityImpl implements LegalEntity {
		private final String id;
		private final EntityName entityName;
		private final List<? extends EntityId> entityId;
		
		protected LegalEntityImpl(LegalEntity.LegalEntityBuilder builder) {
			this.id = builder.getId();
			this.entityName = ofNullable(builder.getEntityName()).map(f->f.build()).orElse(null);
			this.entityId = ofNullable(builder.getEntityId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("entityName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityName")
		public EntityName getEntityName() {
			return entityName;
		}
		
		@Override
		@RosettaAttribute("entityId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("entityId")
		public List<? extends EntityId> getEntityId() {
			return entityId;
		}
		
		@Override
		public LegalEntity build() {
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder toBuilder() {
			LegalEntity.LegalEntityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalEntity.LegalEntityBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getEntityName()).ifPresent(builder::setEntityName);
			ofNullable(getEntityId()).ifPresent(builder::setEntityId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalEntity _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(entityName, _that.getEntityName())) return false;
			if (!ListEquals.listEquals(entityId, _that.getEntityId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (entityName != null ? entityName.hashCode() : 0);
			_result = 31 * _result + (entityId != null ? entityId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalEntity {" +
				"id=" + this.id + ", " +
				"entityName=" + this.entityName + ", " +
				"entityId=" + this.entityId +
			'}';
		}
	}

	/*********************** Builder Implementation of LegalEntity  ***********************/
	class LegalEntityBuilderImpl implements LegalEntity.LegalEntityBuilder {
	
		protected String id;
		protected EntityName.EntityNameBuilder entityName;
		protected List<EntityId.EntityIdBuilder> entityId = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("entityName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityName")
		public EntityName.EntityNameBuilder getEntityName() {
			return entityName;
		}
		
		@Override
		public EntityName.EntityNameBuilder getOrCreateEntityName() {
			EntityName.EntityNameBuilder result;
			if (entityName!=null) {
				result = entityName;
			}
			else {
				result = entityName = EntityName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("entityId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("entityId")
		public List<? extends EntityId.EntityIdBuilder> getEntityId() {
			return entityId;
		}
		
		@Override
		public EntityId.EntityIdBuilder getOrCreateEntityId(int index) {
			if (entityId==null) {
				this.entityId = new ArrayList<>();
			}
			return getIndex(entityId, index, () -> {
						EntityId.EntityIdBuilder newEntityId = EntityId.builder();
						return newEntityId;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LegalEntity.LegalEntityBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("entityName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityName")
		@Override
		public LegalEntity.LegalEntityBuilder setEntityName(EntityName _entityName) {
			this.entityName = _entityName == null ? null : _entityName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("entityId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("entityId")
		@Override
		public LegalEntity.LegalEntityBuilder addEntityId(EntityId _entityId) {
			if (_entityId != null) {
				this.entityId.add(_entityId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder addEntityId(EntityId _entityId, int idx) {
			getIndex(this.entityId, idx, () -> _entityId.toBuilder());
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder addEntityId(List<? extends EntityId> entityIds) {
			if (entityIds != null) {
				for (final EntityId toAdd : entityIds) {
					this.entityId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("entityId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("entityId")
		@Override
		public LegalEntity.LegalEntityBuilder setEntityId(List<? extends EntityId> entityIds) {
			if (entityIds == null) {
				this.entityId = new ArrayList<>();
			} else {
				this.entityId = entityIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LegalEntity build() {
			return new LegalEntity.LegalEntityImpl(this);
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalEntity.LegalEntityBuilder prune() {
			if (entityName!=null && !entityName.prune().hasData()) entityName = null;
			entityId = entityId.stream().filter(b->b!=null).<EntityId.EntityIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getEntityName()!=null && getEntityName().hasData()) return true;
			if (getEntityId()!=null && getEntityId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalEntity.LegalEntityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegalEntity.LegalEntityBuilder o = (LegalEntity.LegalEntityBuilder) other;
			
			merger.mergeRosetta(getEntityName(), o.getEntityName(), this::setEntityName);
			merger.mergeRosetta(getEntityId(), o.getEntityId(), this::getOrCreateEntityId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalEntity _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(entityName, _that.getEntityName())) return false;
			if (!ListEquals.listEquals(entityId, _that.getEntityId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (entityName != null ? entityName.hashCode() : 0);
			_result = 31 * _result + (entityId != null ? entityId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalEntityBuilder {" +
				"id=" + this.id + ", " +
				"entityName=" + this.entityName + ", " +
				"entityId=" + this.entityId +
			'}';
		}
	}
}
