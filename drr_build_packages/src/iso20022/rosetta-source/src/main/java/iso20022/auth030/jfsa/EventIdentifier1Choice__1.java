package iso20022.auth030.jfsa;

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
import iso20022.auth030.jfsa.meta.EventIdentifier1Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="EventIdentifier1Choice__1", builder=EventIdentifier1Choice__1.EventIdentifier1Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EventIdentifier1Choice__1", model="iso20022", builder=EventIdentifier1Choice__1.EventIdentifier1Choice__1BuilderImpl.class, version="${project.version}")
public interface EventIdentifier1Choice__1 extends RosettaModelObject {

	EventIdentifier1Choice__1Meta metaData = new EventIdentifier1Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	String getEvtIdr();

	/*********************** Build Methods  ***********************/
	EventIdentifier1Choice__1 build();
	
	EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder toBuilder();
	
	static EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder builder() {
		return new EventIdentifier1Choice__1.EventIdentifier1Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventIdentifier1Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EventIdentifier1Choice__1> getType() {
		return EventIdentifier1Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("evtIdr"), String.class, getEvtIdr(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventIdentifier1Choice__1Builder extends EventIdentifier1Choice__1, RosettaModelObjectBuilder {
		EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder setEvtIdr(String evtIdr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("evtIdr"), String.class, getEvtIdr(), this);
		}
		

		EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of EventIdentifier1Choice__1  ***********************/
	class EventIdentifier1Choice__1Impl implements EventIdentifier1Choice__1 {
		private final String evtIdr;
		
		protected EventIdentifier1Choice__1Impl(EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder builder) {
			this.evtIdr = builder.getEvtIdr();
		}
		
		@Override
		@RosettaAttribute("evtIdr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("evtIdr")
		public String getEvtIdr() {
			return evtIdr;
		}
		
		@Override
		public EventIdentifier1Choice__1 build() {
			return this;
		}
		
		@Override
		public EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder toBuilder() {
			EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder builder) {
			ofNullable(getEvtIdr()).ifPresent(builder::setEvtIdr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventIdentifier1Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(evtIdr, _that.getEvtIdr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (evtIdr != null ? evtIdr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventIdentifier1Choice__1 {" +
				"evtIdr=" + this.evtIdr +
			'}';
		}
	}

	/*********************** Builder Implementation of EventIdentifier1Choice__1  ***********************/
	class EventIdentifier1Choice__1BuilderImpl implements EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder {
	
		protected String evtIdr;
		
		@Override
		@RosettaAttribute("evtIdr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("evtIdr")
		public String getEvtIdr() {
			return evtIdr;
		}
		
		@RosettaAttribute("evtIdr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("evtIdr")
		@Override
		public EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder setEvtIdr(String _evtIdr) {
			this.evtIdr = _evtIdr == null ? null : _evtIdr;
			return this;
		}
		
		@Override
		public EventIdentifier1Choice__1 build() {
			return new EventIdentifier1Choice__1.EventIdentifier1Choice__1Impl(this);
		}
		
		@Override
		public EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEvtIdr()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder o = (EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder) other;
			
			
			merger.mergeBasic(getEvtIdr(), o.getEvtIdr(), this::setEvtIdr);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventIdentifier1Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(evtIdr, _that.getEvtIdr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (evtIdr != null ? evtIdr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventIdentifier1Choice__1Builder {" +
				"evtIdr=" + this.evtIdr +
			'}';
		}
	}
}
