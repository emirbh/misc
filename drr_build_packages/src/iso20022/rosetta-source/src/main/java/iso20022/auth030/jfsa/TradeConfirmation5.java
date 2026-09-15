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
import iso20022.auth030.jfsa.meta.TradeConfirmation5Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeConfirmation5", builder=TradeConfirmation5.TradeConfirmation5BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeConfirmation5", model="iso20022", builder=TradeConfirmation5.TradeConfirmation5BuilderImpl.class, version="${project.version}")
public interface TradeConfirmation5 extends RosettaModelObject {

	TradeConfirmation5Meta metaData = new TradeConfirmation5Meta();

	/*********************** Getter Methods  ***********************/
	TradeConfirmationType1Code getTp();
	ZonedDateTime getTmStmp();

	/*********************** Build Methods  ***********************/
	TradeConfirmation5 build();
	
	TradeConfirmation5.TradeConfirmation5Builder toBuilder();
	
	static TradeConfirmation5.TradeConfirmation5Builder builder() {
		return new TradeConfirmation5.TradeConfirmation5BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeConfirmation5> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeConfirmation5> getType() {
		return TradeConfirmation5.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tp"), TradeConfirmationType1Code.class, getTp(), this);
		processor.processBasic(path.newSubPath("tmStmp"), ZonedDateTime.class, getTmStmp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeConfirmation5Builder extends TradeConfirmation5, RosettaModelObjectBuilder {
		TradeConfirmation5.TradeConfirmation5Builder setTp(TradeConfirmationType1Code tp);
		TradeConfirmation5.TradeConfirmation5Builder setTmStmp(ZonedDateTime tmStmp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tp"), TradeConfirmationType1Code.class, getTp(), this);
			processor.processBasic(path.newSubPath("tmStmp"), ZonedDateTime.class, getTmStmp(), this);
		}
		

		TradeConfirmation5.TradeConfirmation5Builder prune();
	}

	/*********************** Immutable Implementation of TradeConfirmation5  ***********************/
	class TradeConfirmation5Impl implements TradeConfirmation5 {
		private final TradeConfirmationType1Code tp;
		private final ZonedDateTime tmStmp;
		
		protected TradeConfirmation5Impl(TradeConfirmation5.TradeConfirmation5Builder builder) {
			this.tp = builder.getTp();
			this.tmStmp = builder.getTmStmp();
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public TradeConfirmationType1Code getTp() {
			return tp;
		}
		
		@Override
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tmStmp")
		public ZonedDateTime getTmStmp() {
			return tmStmp;
		}
		
		@Override
		public TradeConfirmation5 build() {
			return this;
		}
		
		@Override
		public TradeConfirmation5.TradeConfirmation5Builder toBuilder() {
			TradeConfirmation5.TradeConfirmation5Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeConfirmation5.TradeConfirmation5Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
			ofNullable(getTmStmp()).ifPresent(builder::setTmStmp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeConfirmation5 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeConfirmation5 {" +
				"tp=" + this.tp + ", " +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeConfirmation5  ***********************/
	class TradeConfirmation5BuilderImpl implements TradeConfirmation5.TradeConfirmation5Builder {
	
		protected TradeConfirmationType1Code tp;
		protected ZonedDateTime tmStmp;
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public TradeConfirmationType1Code getTp() {
			return tp;
		}
		
		@Override
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tmStmp")
		public ZonedDateTime getTmStmp() {
			return tmStmp;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tp")
		@Override
		public TradeConfirmation5.TradeConfirmation5Builder setTp(TradeConfirmationType1Code _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tmStmp")
		@Override
		public TradeConfirmation5.TradeConfirmation5Builder setTmStmp(ZonedDateTime _tmStmp) {
			this.tmStmp = _tmStmp == null ? null : _tmStmp;
			return this;
		}
		
		@Override
		public TradeConfirmation5 build() {
			return new TradeConfirmation5.TradeConfirmation5Impl(this);
		}
		
		@Override
		public TradeConfirmation5.TradeConfirmation5Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeConfirmation5.TradeConfirmation5Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTp()!=null) return true;
			if (getTmStmp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeConfirmation5.TradeConfirmation5Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeConfirmation5.TradeConfirmation5Builder o = (TradeConfirmation5.TradeConfirmation5Builder) other;
			
			
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			merger.mergeBasic(getTmStmp(), o.getTmStmp(), this::setTmStmp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeConfirmation5 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeConfirmation5Builder {" +
				"tp=" + this.tp + ", " +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}
}
