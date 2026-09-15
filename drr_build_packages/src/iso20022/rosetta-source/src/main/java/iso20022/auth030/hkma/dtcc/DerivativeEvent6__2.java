package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.DerivativeEvent6__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to derivative details.
 * @version ${project.version}
 */
@RosettaDataType(value="DerivativeEvent6__2", builder=DerivativeEvent6__2.DerivativeEvent6__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="DerivativeEvent6__2", model="iso20022", builder=DerivativeEvent6__2.DerivativeEvent6__2BuilderImpl.class, version="${project.version}")
public interface DerivativeEvent6__2 extends RosettaModelObject {

	DerivativeEvent6__2Meta metaData = new DerivativeEvent6__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Classification of derivative event type.
	 */
	DerivativeEventType3Code__2 getTp();
	/**
	 * Indicates means of identification of a derivative event.
	 */
	EventIdentifier1Choice__1 getId();
	/**
	 * Indicates the time stamp of a derivative event.
	 */
	DateAndDateTime2Choice__1 getTmStmp();

	/*********************** Build Methods  ***********************/
	DerivativeEvent6__2 build();
	
	DerivativeEvent6__2.DerivativeEvent6__2Builder toBuilder();
	
	static DerivativeEvent6__2.DerivativeEvent6__2Builder builder() {
		return new DerivativeEvent6__2.DerivativeEvent6__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativeEvent6__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DerivativeEvent6__2> getType() {
		return DerivativeEvent6__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tp"), DerivativeEventType3Code__2.class, getTp(), this);
		processRosetta(path.newSubPath("id"), processor, EventIdentifier1Choice__1.class, getId());
		processRosetta(path.newSubPath("tmStmp"), processor, DateAndDateTime2Choice__1.class, getTmStmp());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativeEvent6__2Builder extends DerivativeEvent6__2, RosettaModelObjectBuilder {
		EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder getOrCreateId();
		@Override
		EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder getId();
		DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder getOrCreateTmStmp();
		@Override
		DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder getTmStmp();
		DerivativeEvent6__2.DerivativeEvent6__2Builder setTp(DerivativeEventType3Code__2 tp);
		DerivativeEvent6__2.DerivativeEvent6__2Builder setId(EventIdentifier1Choice__1 id);
		DerivativeEvent6__2.DerivativeEvent6__2Builder setTmStmp(DateAndDateTime2Choice__1 tmStmp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tp"), DerivativeEventType3Code__2.class, getTp(), this);
			processRosetta(path.newSubPath("id"), processor, EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder.class, getId());
			processRosetta(path.newSubPath("tmStmp"), processor, DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder.class, getTmStmp());
		}
		

		DerivativeEvent6__2.DerivativeEvent6__2Builder prune();
	}

	/*********************** Immutable Implementation of DerivativeEvent6__2  ***********************/
	class DerivativeEvent6__2Impl implements DerivativeEvent6__2 {
		private final DerivativeEventType3Code__2 tp;
		private final EventIdentifier1Choice__1 id;
		private final DateAndDateTime2Choice__1 tmStmp;
		
		protected DerivativeEvent6__2Impl(DerivativeEvent6__2.DerivativeEvent6__2Builder builder) {
			this.tp = builder.getTp();
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.tmStmp = ofNullable(builder.getTmStmp()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tp")
		public DerivativeEventType3Code__2 getTp() {
			return tp;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public EventIdentifier1Choice__1 getId() {
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
		public DerivativeEvent6__2 build() {
			return this;
		}
		
		@Override
		public DerivativeEvent6__2.DerivativeEvent6__2Builder toBuilder() {
			DerivativeEvent6__2.DerivativeEvent6__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativeEvent6__2.DerivativeEvent6__2Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getTmStmp()).ifPresent(builder::setTmStmp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeEvent6__2 _that = getType().cast(o);
		
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
			return "DerivativeEvent6__2 {" +
				"tp=" + this.tp + ", " +
				"id=" + this.id + ", " +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativeEvent6__2  ***********************/
	class DerivativeEvent6__2BuilderImpl implements DerivativeEvent6__2.DerivativeEvent6__2Builder {
	
		protected DerivativeEventType3Code__2 tp;
		protected EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder id;
		protected DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder tmStmp;
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tp")
		public DerivativeEventType3Code__2 getTp() {
			return tp;
		}
		
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
		@RuneAttribute("tp")
		@Override
		public DerivativeEvent6__2.DerivativeEvent6__2Builder setTp(DerivativeEventType3Code__2 _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DerivativeEvent6__2.DerivativeEvent6__2Builder setId(EventIdentifier1Choice__1 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tmStmp")
		@Override
		public DerivativeEvent6__2.DerivativeEvent6__2Builder setTmStmp(DateAndDateTime2Choice__1 _tmStmp) {
			this.tmStmp = _tmStmp == null ? null : _tmStmp.toBuilder();
			return this;
		}
		
		@Override
		public DerivativeEvent6__2 build() {
			return new DerivativeEvent6__2.DerivativeEvent6__2Impl(this);
		}
		
		@Override
		public DerivativeEvent6__2.DerivativeEvent6__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeEvent6__2.DerivativeEvent6__2Builder prune() {
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
		public DerivativeEvent6__2.DerivativeEvent6__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativeEvent6__2.DerivativeEvent6__2Builder o = (DerivativeEvent6__2.DerivativeEvent6__2Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			merger.mergeRosetta(getTmStmp(), o.getTmStmp(), this::setTmStmp);
			
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeEvent6__2 _that = getType().cast(o);
		
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
			return "DerivativeEvent6__2Builder {" +
				"tp=" + this.tp + ", " +
				"id=" + this.id + ", " +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}
}
