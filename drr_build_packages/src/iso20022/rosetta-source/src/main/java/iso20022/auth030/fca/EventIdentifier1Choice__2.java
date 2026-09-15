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
import iso20022.auth030.fca.meta.EventIdentifier1Choice__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indicates an event identifier or post trade risk reduction identifier.
 * @version ${project.version}
 */
@RosettaDataType(value="EventIdentifier1Choice__2", builder=EventIdentifier1Choice__2.EventIdentifier1Choice__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EventIdentifier1Choice__2", model="iso20022", builder=EventIdentifier1Choice__2.EventIdentifier1Choice__2BuilderImpl.class, version="${project.version}")
public interface EventIdentifier1Choice__2 extends RosettaModelObject {

	EventIdentifier1Choice__2Meta metaData = new EventIdentifier1Choice__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies post trade risk reduction identifier.
	 */
	PostTradeRiskReductionIdentifier1 getPstTradRskRdctnIdr();

	/*********************** Build Methods  ***********************/
	EventIdentifier1Choice__2 build();
	
	EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder toBuilder();
	
	static EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder builder() {
		return new EventIdentifier1Choice__2.EventIdentifier1Choice__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventIdentifier1Choice__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EventIdentifier1Choice__2> getType() {
		return EventIdentifier1Choice__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pstTradRskRdctnIdr"), processor, PostTradeRiskReductionIdentifier1.class, getPstTradRskRdctnIdr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventIdentifier1Choice__2Builder extends EventIdentifier1Choice__2, RosettaModelObjectBuilder {
		PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder getOrCreatePstTradRskRdctnIdr();
		@Override
		PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder getPstTradRskRdctnIdr();
		EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder setPstTradRskRdctnIdr(PostTradeRiskReductionIdentifier1 pstTradRskRdctnIdr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pstTradRskRdctnIdr"), processor, PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder.class, getPstTradRskRdctnIdr());
		}
		

		EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder prune();
	}

	/*********************** Immutable Implementation of EventIdentifier1Choice__2  ***********************/
	class EventIdentifier1Choice__2Impl implements EventIdentifier1Choice__2 {
		private final PostTradeRiskReductionIdentifier1 pstTradRskRdctnIdr;
		
		protected EventIdentifier1Choice__2Impl(EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder builder) {
			this.pstTradRskRdctnIdr = ofNullable(builder.getPstTradRskRdctnIdr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pstTradRskRdctnIdr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pstTradRskRdctnIdr")
		public PostTradeRiskReductionIdentifier1 getPstTradRskRdctnIdr() {
			return pstTradRskRdctnIdr;
		}
		
		@Override
		public EventIdentifier1Choice__2 build() {
			return this;
		}
		
		@Override
		public EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder toBuilder() {
			EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder builder) {
			ofNullable(getPstTradRskRdctnIdr()).ifPresent(builder::setPstTradRskRdctnIdr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventIdentifier1Choice__2 _that = getType().cast(o);
		
			if (!Objects.equals(pstTradRskRdctnIdr, _that.getPstTradRskRdctnIdr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pstTradRskRdctnIdr != null ? pstTradRskRdctnIdr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventIdentifier1Choice__2 {" +
				"pstTradRskRdctnIdr=" + this.pstTradRskRdctnIdr +
			'}';
		}
	}

	/*********************** Builder Implementation of EventIdentifier1Choice__2  ***********************/
	class EventIdentifier1Choice__2BuilderImpl implements EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder {
	
		protected PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder pstTradRskRdctnIdr;
		
		@Override
		@RosettaAttribute("pstTradRskRdctnIdr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pstTradRskRdctnIdr")
		public PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder getPstTradRskRdctnIdr() {
			return pstTradRskRdctnIdr;
		}
		
		@Override
		public PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder getOrCreatePstTradRskRdctnIdr() {
			PostTradeRiskReductionIdentifier1.PostTradeRiskReductionIdentifier1Builder result;
			if (pstTradRskRdctnIdr!=null) {
				result = pstTradRskRdctnIdr;
			}
			else {
				result = pstTradRskRdctnIdr = PostTradeRiskReductionIdentifier1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("pstTradRskRdctnIdr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("pstTradRskRdctnIdr")
		@Override
		public EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder setPstTradRskRdctnIdr(PostTradeRiskReductionIdentifier1 _pstTradRskRdctnIdr) {
			this.pstTradRskRdctnIdr = _pstTradRskRdctnIdr == null ? null : _pstTradRskRdctnIdr.toBuilder();
			return this;
		}
		
		@Override
		public EventIdentifier1Choice__2 build() {
			return new EventIdentifier1Choice__2.EventIdentifier1Choice__2Impl(this);
		}
		
		@Override
		public EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder prune() {
			if (pstTradRskRdctnIdr!=null && !pstTradRskRdctnIdr.prune().hasData()) pstTradRskRdctnIdr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPstTradRskRdctnIdr()!=null && getPstTradRskRdctnIdr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder o = (EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder) other;
			
			merger.mergeRosetta(getPstTradRskRdctnIdr(), o.getPstTradRskRdctnIdr(), this::setPstTradRskRdctnIdr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventIdentifier1Choice__2 _that = getType().cast(o);
		
			if (!Objects.equals(pstTradRskRdctnIdr, _that.getPstTradRskRdctnIdr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pstTradRskRdctnIdr != null ? pstTradRskRdctnIdr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventIdentifier1Choice__2Builder {" +
				"pstTradRskRdctnIdr=" + this.pstTradRskRdctnIdr +
			'}';
		}
	}
}
