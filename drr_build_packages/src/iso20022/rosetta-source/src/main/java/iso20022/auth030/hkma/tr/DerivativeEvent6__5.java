package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.DerivativeEvent6__5Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to derivative details.
 * @version ${project.version}
 */
@RosettaDataType(value="DerivativeEvent6__5", builder=DerivativeEvent6__5.DerivativeEvent6__5BuilderImpl.class, version="${project.version}")
@RuneDataType(value="DerivativeEvent6__5", model="iso20022", builder=DerivativeEvent6__5.DerivativeEvent6__5BuilderImpl.class, version="${project.version}")
public interface DerivativeEvent6__5 extends RosettaModelObject {

	DerivativeEvent6__5Meta metaData = new DerivativeEvent6__5Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates means of identification of a derivative event.
	 */
	EventIdentifier1Choice__1 getId();

	/*********************** Build Methods  ***********************/
	DerivativeEvent6__5 build();
	
	DerivativeEvent6__5.DerivativeEvent6__5Builder toBuilder();
	
	static DerivativeEvent6__5.DerivativeEvent6__5Builder builder() {
		return new DerivativeEvent6__5.DerivativeEvent6__5BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativeEvent6__5> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DerivativeEvent6__5> getType() {
		return DerivativeEvent6__5.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, EventIdentifier1Choice__1.class, getId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativeEvent6__5Builder extends DerivativeEvent6__5, RosettaModelObjectBuilder {
		EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder getOrCreateId();
		@Override
		EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder getId();
		DerivativeEvent6__5.DerivativeEvent6__5Builder setId(EventIdentifier1Choice__1 id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder.class, getId());
		}
		

		DerivativeEvent6__5.DerivativeEvent6__5Builder prune();
	}

	/*********************** Immutable Implementation of DerivativeEvent6__5  ***********************/
	class DerivativeEvent6__5Impl implements DerivativeEvent6__5 {
		private final EventIdentifier1Choice__1 id;
		
		protected DerivativeEvent6__5Impl(DerivativeEvent6__5.DerivativeEvent6__5Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public EventIdentifier1Choice__1 getId() {
			return id;
		}
		
		@Override
		public DerivativeEvent6__5 build() {
			return this;
		}
		
		@Override
		public DerivativeEvent6__5.DerivativeEvent6__5Builder toBuilder() {
			DerivativeEvent6__5.DerivativeEvent6__5Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativeEvent6__5.DerivativeEvent6__5Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeEvent6__5 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeEvent6__5 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativeEvent6__5  ***********************/
	class DerivativeEvent6__5BuilderImpl implements DerivativeEvent6__5.DerivativeEvent6__5Builder {
	
		protected EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder id;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder getId() {
			return id;
		}
		
		@Override
		public EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder getOrCreateId() {
			EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = EventIdentifier1Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DerivativeEvent6__5.DerivativeEvent6__5Builder setId(EventIdentifier1Choice__1 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@Override
		public DerivativeEvent6__5 build() {
			return new DerivativeEvent6__5.DerivativeEvent6__5Impl(this);
		}
		
		@Override
		public DerivativeEvent6__5.DerivativeEvent6__5Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeEvent6__5.DerivativeEvent6__5Builder prune() {
			if (id!=null && !id.prune().hasData()) id = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null && getId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeEvent6__5.DerivativeEvent6__5Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativeEvent6__5.DerivativeEvent6__5Builder o = (DerivativeEvent6__5.DerivativeEvent6__5Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeEvent6__5 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeEvent6__5Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
