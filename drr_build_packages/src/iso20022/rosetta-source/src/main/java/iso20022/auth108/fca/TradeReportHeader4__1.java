package iso20022.auth108.fca;

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
import iso20022.auth108.fca.meta.TradeReportHeader4__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides the details of the header for a trade transaction query message.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeReportHeader4__1", builder=TradeReportHeader4__1.TradeReportHeader4__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeReportHeader4__1", model="iso20022", builder=TradeReportHeader4__1.TradeReportHeader4__1BuilderImpl.class, version="${project.version}")
public interface TradeReportHeader4__1 extends RosettaModelObject {

	TradeReportHeader4__1Meta metaData = new TradeReportHeader4__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the number of records in the page.
	 */
	Long getNbRcrds();

	/*********************** Build Methods  ***********************/
	TradeReportHeader4__1 build();
	
	TradeReportHeader4__1.TradeReportHeader4__1Builder toBuilder();
	
	static TradeReportHeader4__1.TradeReportHeader4__1Builder builder() {
		return new TradeReportHeader4__1.TradeReportHeader4__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeReportHeader4__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeReportHeader4__1> getType() {
		return TradeReportHeader4__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("nbRcrds"), Long.class, getNbRcrds(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeReportHeader4__1Builder extends TradeReportHeader4__1, RosettaModelObjectBuilder {
		TradeReportHeader4__1.TradeReportHeader4__1Builder setNbRcrds(Long nbRcrds);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("nbRcrds"), Long.class, getNbRcrds(), this);
		}
		

		TradeReportHeader4__1.TradeReportHeader4__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeReportHeader4__1  ***********************/
	class TradeReportHeader4__1Impl implements TradeReportHeader4__1 {
		private final Long nbRcrds;
		
		protected TradeReportHeader4__1Impl(TradeReportHeader4__1.TradeReportHeader4__1Builder builder) {
			this.nbRcrds = builder.getNbRcrds();
		}
		
		@Override
		@RosettaAttribute("nbRcrds")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nbRcrds")
		public Long getNbRcrds() {
			return nbRcrds;
		}
		
		@Override
		public TradeReportHeader4__1 build() {
			return this;
		}
		
		@Override
		public TradeReportHeader4__1.TradeReportHeader4__1Builder toBuilder() {
			TradeReportHeader4__1.TradeReportHeader4__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeReportHeader4__1.TradeReportHeader4__1Builder builder) {
			ofNullable(getNbRcrds()).ifPresent(builder::setNbRcrds);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReportHeader4__1 _that = getType().cast(o);
		
			if (!Objects.equals(nbRcrds, _that.getNbRcrds())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nbRcrds != null ? nbRcrds.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReportHeader4__1 {" +
				"nbRcrds=" + this.nbRcrds +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeReportHeader4__1  ***********************/
	class TradeReportHeader4__1BuilderImpl implements TradeReportHeader4__1.TradeReportHeader4__1Builder {
	
		protected Long nbRcrds;
		
		@Override
		@RosettaAttribute("nbRcrds")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nbRcrds")
		public Long getNbRcrds() {
			return nbRcrds;
		}
		
		@RosettaAttribute("nbRcrds")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nbRcrds")
		@Override
		public TradeReportHeader4__1.TradeReportHeader4__1Builder setNbRcrds(Long _nbRcrds) {
			this.nbRcrds = _nbRcrds == null ? null : _nbRcrds;
			return this;
		}
		
		@Override
		public TradeReportHeader4__1 build() {
			return new TradeReportHeader4__1.TradeReportHeader4__1Impl(this);
		}
		
		@Override
		public TradeReportHeader4__1.TradeReportHeader4__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReportHeader4__1.TradeReportHeader4__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNbRcrds()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReportHeader4__1.TradeReportHeader4__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeReportHeader4__1.TradeReportHeader4__1Builder o = (TradeReportHeader4__1.TradeReportHeader4__1Builder) other;
			
			
			merger.mergeBasic(getNbRcrds(), o.getNbRcrds(), this::setNbRcrds);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReportHeader4__1 _that = getType().cast(o);
		
			if (!Objects.equals(nbRcrds, _that.getNbRcrds())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nbRcrds != null ? nbRcrds.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReportHeader4__1Builder {" +
				"nbRcrds=" + this.nbRcrds +
			'}';
		}
	}
}
