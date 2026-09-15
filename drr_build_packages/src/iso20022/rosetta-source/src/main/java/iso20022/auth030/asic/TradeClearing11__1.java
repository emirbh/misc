package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.TradeClearing11__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeClearing11__1", builder=TradeClearing11__1.TradeClearing11__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeClearing11__1", model="iso20022", builder=TradeClearing11__1.TradeClearing11__1BuilderImpl.class, version="${project.version}")
public interface TradeClearing11__1 extends RosettaModelObject {

	TradeClearing11__1Meta metaData = new TradeClearing11__1Meta();

	/*********************** Getter Methods  ***********************/
	Cleared23Choice__1 getClrSts();

	/*********************** Build Methods  ***********************/
	TradeClearing11__1 build();
	
	TradeClearing11__1.TradeClearing11__1Builder toBuilder();
	
	static TradeClearing11__1.TradeClearing11__1Builder builder() {
		return new TradeClearing11__1.TradeClearing11__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeClearing11__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeClearing11__1> getType() {
		return TradeClearing11__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("clrSts"), processor, Cleared23Choice__1.class, getClrSts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeClearing11__1Builder extends TradeClearing11__1, RosettaModelObjectBuilder {
		Cleared23Choice__1.Cleared23Choice__1Builder getOrCreateClrSts();
		@Override
		Cleared23Choice__1.Cleared23Choice__1Builder getClrSts();
		TradeClearing11__1.TradeClearing11__1Builder setClrSts(Cleared23Choice__1 clrSts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("clrSts"), processor, Cleared23Choice__1.Cleared23Choice__1Builder.class, getClrSts());
		}
		

		TradeClearing11__1.TradeClearing11__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeClearing11__1  ***********************/
	class TradeClearing11__1Impl implements TradeClearing11__1 {
		private final Cleared23Choice__1 clrSts;
		
		protected TradeClearing11__1Impl(TradeClearing11__1.TradeClearing11__1Builder builder) {
			this.clrSts = ofNullable(builder.getClrSts()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("clrSts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("clrSts")
		public Cleared23Choice__1 getClrSts() {
			return clrSts;
		}
		
		@Override
		public TradeClearing11__1 build() {
			return this;
		}
		
		@Override
		public TradeClearing11__1.TradeClearing11__1Builder toBuilder() {
			TradeClearing11__1.TradeClearing11__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeClearing11__1.TradeClearing11__1Builder builder) {
			ofNullable(getClrSts()).ifPresent(builder::setClrSts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeClearing11__1 _that = getType().cast(o);
		
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
			return "TradeClearing11__1 {" +
				"clrSts=" + this.clrSts +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeClearing11__1  ***********************/
	class TradeClearing11__1BuilderImpl implements TradeClearing11__1.TradeClearing11__1Builder {
	
		protected Cleared23Choice__1.Cleared23Choice__1Builder clrSts;
		
		@Override
		@RosettaAttribute("clrSts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("clrSts")
		public Cleared23Choice__1.Cleared23Choice__1Builder getClrSts() {
			return clrSts;
		}
		
		@Override
		public Cleared23Choice__1.Cleared23Choice__1Builder getOrCreateClrSts() {
			Cleared23Choice__1.Cleared23Choice__1Builder result;
			if (clrSts!=null) {
				result = clrSts;
			}
			else {
				result = clrSts = Cleared23Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("clrSts")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("clrSts")
		@Override
		public TradeClearing11__1.TradeClearing11__1Builder setClrSts(Cleared23Choice__1 _clrSts) {
			this.clrSts = _clrSts == null ? null : _clrSts.toBuilder();
			return this;
		}
		
		@Override
		public TradeClearing11__1 build() {
			return new TradeClearing11__1.TradeClearing11__1Impl(this);
		}
		
		@Override
		public TradeClearing11__1.TradeClearing11__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeClearing11__1.TradeClearing11__1Builder prune() {
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
		public TradeClearing11__1.TradeClearing11__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeClearing11__1.TradeClearing11__1Builder o = (TradeClearing11__1.TradeClearing11__1Builder) other;
			
			merger.mergeRosetta(getClrSts(), o.getClrSts(), this::setClrSts);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeClearing11__1 _that = getType().cast(o);
		
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
			return "TradeClearing11__1Builder {" +
				"clrSts=" + this.clrSts +
			'}';
		}
	}
}
