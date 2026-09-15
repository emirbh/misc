package iso20022.auth030.fca;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import iso20022.auth030.fca.meta.DerivativeEvent6__4Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to derivative details.
 * @version ${project.version}
 */
@RosettaDataType(value="DerivativeEvent6__4", builder=DerivativeEvent6__4.DerivativeEvent6__4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="DerivativeEvent6__4", model="iso20022", builder=DerivativeEvent6__4.DerivativeEvent6__4BuilderImpl.class, version="${project.version}")
public interface DerivativeEvent6__4 extends RosettaModelObject {

	DerivativeEvent6__4Meta metaData = new DerivativeEvent6__4Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Classification of derivative event type.
	 */
	DerivativeEventType3Code__1 getTp();
	/**
	 * Indicates means of identification of a derivative event.
	 */
	EventIdentifier1Choice__2 getId();
	/**
	 * Indicates the time stamp of a derivative event.
	 */
	DateAndDateTime2Choice__1 getTmStmp();

	/*********************** Build Methods  ***********************/
	DerivativeEvent6__4 build();
	
	DerivativeEvent6__4.DerivativeEvent6__4Builder toBuilder();
	
	static DerivativeEvent6__4.DerivativeEvent6__4Builder builder() {
		return new DerivativeEvent6__4.DerivativeEvent6__4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativeEvent6__4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DerivativeEvent6__4> getType() {
		return DerivativeEvent6__4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tp"), DerivativeEventType3Code__1.class, getTp(), this);
		processRosetta(path.newSubPath("id"), processor, EventIdentifier1Choice__2.class, getId());
		processRosetta(path.newSubPath("tmStmp"), processor, DateAndDateTime2Choice__1.class, getTmStmp());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativeEvent6__4Builder extends DerivativeEvent6__4, RosettaModelObjectBuilder {
		EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder getOrCreateId();
		@Override
		EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder getId();
		DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder getOrCreateTmStmp();
		@Override
		DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder getTmStmp();
		DerivativeEvent6__4.DerivativeEvent6__4Builder setTp(DerivativeEventType3Code__1 tp);
		DerivativeEvent6__4.DerivativeEvent6__4Builder setId(EventIdentifier1Choice__2 id);
		DerivativeEvent6__4.DerivativeEvent6__4Builder setTmStmp(DateAndDateTime2Choice__1 tmStmp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tp"), DerivativeEventType3Code__1.class, getTp(), this);
			processRosetta(path.newSubPath("id"), processor, EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder.class, getId());
			processRosetta(path.newSubPath("tmStmp"), processor, DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder.class, getTmStmp());
		}
		

		DerivativeEvent6__4.DerivativeEvent6__4Builder prune();
	}

	/*********************** Immutable Implementation of DerivativeEvent6__4  ***********************/
	class DerivativeEvent6__4Impl implements DerivativeEvent6__4 {
		private final DerivativeEventType3Code__1 tp;
		private final EventIdentifier1Choice__2 id;
		private final DateAndDateTime2Choice__1 tmStmp;
		
		protected DerivativeEvent6__4Impl(DerivativeEvent6__4.DerivativeEvent6__4Builder builder) {
			this.tp = builder.getTp();
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.tmStmp = ofNullable(builder.getTmStmp()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public DerivativeEventType3Code__1 getTp() {
			return tp;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public EventIdentifier1Choice__2 getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tmStmp")
		public DateAndDateTime2Choice__1 getTmStmp() {
			return tmStmp;
		}
		
		@Override
		public DerivativeEvent6__4 build() {
			return this;
		}
		
		@Override
		public DerivativeEvent6__4.DerivativeEvent6__4Builder toBuilder() {
			DerivativeEvent6__4.DerivativeEvent6__4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativeEvent6__4.DerivativeEvent6__4Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getTmStmp()).ifPresent(builder::setTmStmp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeEvent6__4 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeEvent6__4 {" +
				"tp=" + this.tp + ", " +
				"id=" + this.id + ", " +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativeEvent6__4  ***********************/
	class DerivativeEvent6__4BuilderImpl implements DerivativeEvent6__4.DerivativeEvent6__4Builder {
	
		protected DerivativeEventType3Code__1 tp;
		protected EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder id;
		protected DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder tmStmp;
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public DerivativeEventType3Code__1 getTp() {
			return tp;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder getId() {
			return id;
		}
		
		@Override
		public EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder getOrCreateId() {
			EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = EventIdentifier1Choice__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tmStmp")
		public DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder getTmStmp() {
			return tmStmp;
		}
		
		@Override
		public DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder getOrCreateTmStmp() {
			DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder result;
			if (tmStmp!=null) {
				result = tmStmp;
			}
			else {
				result = tmStmp = DateAndDateTime2Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tp")
		@Override
		public DerivativeEvent6__4.DerivativeEvent6__4Builder setTp(DerivativeEventType3Code__1 _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DerivativeEvent6__4.DerivativeEvent6__4Builder setId(EventIdentifier1Choice__2 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tmStmp")
		@Override
		public DerivativeEvent6__4.DerivativeEvent6__4Builder setTmStmp(DateAndDateTime2Choice__1 _tmStmp) {
			this.tmStmp = _tmStmp == null ? null : _tmStmp.toBuilder();
			return this;
		}
		
		@Override
		public DerivativeEvent6__4 build() {
			return new DerivativeEvent6__4.DerivativeEvent6__4Impl(this);
		}
		
		@Override
		public DerivativeEvent6__4.DerivativeEvent6__4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeEvent6__4.DerivativeEvent6__4Builder prune() {
			if (id!=null && !id.prune().hasData()) id = null;
			if (tmStmp!=null && !tmStmp.prune().hasData()) tmStmp = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTp()!=null) return true;
			if (getId()!=null && getId().hasData()) return true;
			if (getTmStmp()!=null && getTmStmp().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeEvent6__4.DerivativeEvent6__4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativeEvent6__4.DerivativeEvent6__4Builder o = (DerivativeEvent6__4.DerivativeEvent6__4Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			merger.mergeRosetta(getTmStmp(), o.getTmStmp(), this::setTmStmp);
			
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeEvent6__4 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeEvent6__4Builder {" +
				"tp=" + this.tp + ", " +
				"id=" + this.id + ", " +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}
}
