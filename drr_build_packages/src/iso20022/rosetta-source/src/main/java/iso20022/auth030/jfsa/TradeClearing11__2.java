package iso20022.auth030.jfsa;

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
import iso20022.auth030.jfsa.meta.TradeClearing11__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeClearing11__2", builder=TradeClearing11__2.TradeClearing11__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeClearing11__2", model="iso20022", builder=TradeClearing11__2.TradeClearing11__2BuilderImpl.class, version="${project.version}")
public interface TradeClearing11__2 extends RosettaModelObject {

	TradeClearing11__2Meta metaData = new TradeClearing11__2Meta();

	/*********************** Getter Methods  ***********************/
	Cleared23Choice__2 getClrSts();

	/*********************** Build Methods  ***********************/
	TradeClearing11__2 build();
	
	TradeClearing11__2.TradeClearing11__2Builder toBuilder();
	
	static TradeClearing11__2.TradeClearing11__2Builder builder() {
		return new TradeClearing11__2.TradeClearing11__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeClearing11__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeClearing11__2> getType() {
		return TradeClearing11__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("clrSts"), processor, Cleared23Choice__2.class, getClrSts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeClearing11__2Builder extends TradeClearing11__2, RosettaModelObjectBuilder {
		Cleared23Choice__2.Cleared23Choice__2Builder getOrCreateClrSts();
		@Override
		Cleared23Choice__2.Cleared23Choice__2Builder getClrSts();
		TradeClearing11__2.TradeClearing11__2Builder setClrSts(Cleared23Choice__2 clrSts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("clrSts"), processor, Cleared23Choice__2.Cleared23Choice__2Builder.class, getClrSts());
		}
		

		TradeClearing11__2.TradeClearing11__2Builder prune();
	}

	/*********************** Immutable Implementation of TradeClearing11__2  ***********************/
	class TradeClearing11__2Impl implements TradeClearing11__2 {
		private final Cleared23Choice__2 clrSts;
		
		protected TradeClearing11__2Impl(TradeClearing11__2.TradeClearing11__2Builder builder) {
			this.clrSts = ofNullable(builder.getClrSts()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("clrSts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrSts")
		public Cleared23Choice__2 getClrSts() {
			return clrSts;
		}
		
		@Override
		public TradeClearing11__2 build() {
			return this;
		}
		
		@Override
		public TradeClearing11__2.TradeClearing11__2Builder toBuilder() {
			TradeClearing11__2.TradeClearing11__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeClearing11__2.TradeClearing11__2Builder builder) {
			ofNullable(getClrSts()).ifPresent(builder::setClrSts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeClearing11__2 _that = getType().cast(o);
		
			if (!Objects.equals(clrSts, _that.getClrSts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clrSts != null ? clrSts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeClearing11__2 {" +
				"clrSts=" + this.clrSts +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeClearing11__2  ***********************/
	class TradeClearing11__2BuilderImpl implements TradeClearing11__2.TradeClearing11__2Builder {
	
		protected Cleared23Choice__2.Cleared23Choice__2Builder clrSts;
		
		@Override
		@RosettaAttribute("clrSts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrSts")
		public Cleared23Choice__2.Cleared23Choice__2Builder getClrSts() {
			return clrSts;
		}
		
		@Override
		public Cleared23Choice__2.Cleared23Choice__2Builder getOrCreateClrSts() {
			Cleared23Choice__2.Cleared23Choice__2Builder result;
			if (clrSts!=null) {
				result = clrSts;
			}
			else {
				result = clrSts = Cleared23Choice__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("clrSts")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clrSts")
		@Override
		public TradeClearing11__2.TradeClearing11__2Builder setClrSts(Cleared23Choice__2 _clrSts) {
			this.clrSts = _clrSts == null ? null : _clrSts.toBuilder();
			return this;
		}
		
		@Override
		public TradeClearing11__2 build() {
			return new TradeClearing11__2.TradeClearing11__2Impl(this);
		}
		
		@Override
		public TradeClearing11__2.TradeClearing11__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeClearing11__2.TradeClearing11__2Builder prune() {
			if (clrSts!=null && !clrSts.prune().hasData()) clrSts = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getClrSts()!=null && getClrSts().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeClearing11__2.TradeClearing11__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeClearing11__2.TradeClearing11__2Builder o = (TradeClearing11__2.TradeClearing11__2Builder) other;
			
			merger.mergeRosetta(getClrSts(), o.getClrSts(), this::setClrSts);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeClearing11__2 _that = getType().cast(o);
		
			if (!Objects.equals(clrSts, _that.getClrSts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clrSts != null ? clrSts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeClearing11__2Builder {" +
				"clrSts=" + this.clrSts +
			'}';
		}
	}
}
