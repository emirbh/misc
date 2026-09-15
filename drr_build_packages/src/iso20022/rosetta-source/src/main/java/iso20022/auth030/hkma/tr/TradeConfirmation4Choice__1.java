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
import iso20022.auth030.hkma.tr.meta.TradeConfirmation4Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information regarding the confirmation of the contract.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeConfirmation4Choice__1", builder=TradeConfirmation4Choice__1.TradeConfirmation4Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeConfirmation4Choice__1", model="iso20022", builder=TradeConfirmation4Choice__1.TradeConfirmation4Choice__1BuilderImpl.class, version="${project.version}")
public interface TradeConfirmation4Choice__1 extends RosettaModelObject {

	TradeConfirmation4Choice__1Meta metaData = new TradeConfirmation4Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the type of contract confirmation.
	 */
	TradeConfirmation5__1 getConfd();
	/**
	 * Indicates that contract was not confirmed.
	 */
	TradeNonConfirmation1 getNonConfd();

	/*********************** Build Methods  ***********************/
	TradeConfirmation4Choice__1 build();
	
	TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder toBuilder();
	
	static TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder builder() {
		return new TradeConfirmation4Choice__1.TradeConfirmation4Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeConfirmation4Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeConfirmation4Choice__1> getType() {
		return TradeConfirmation4Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("confd"), processor, TradeConfirmation5__1.class, getConfd());
		processRosetta(path.newSubPath("nonConfd"), processor, TradeNonConfirmation1.class, getNonConfd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeConfirmation4Choice__1Builder extends TradeConfirmation4Choice__1, RosettaModelObjectBuilder {
		TradeConfirmation5__1.TradeConfirmation5__1Builder getOrCreateConfd();
		@Override
		TradeConfirmation5__1.TradeConfirmation5__1Builder getConfd();
		TradeNonConfirmation1.TradeNonConfirmation1Builder getOrCreateNonConfd();
		@Override
		TradeNonConfirmation1.TradeNonConfirmation1Builder getNonConfd();
		TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder setConfd(TradeConfirmation5__1 confd);
		TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder setNonConfd(TradeNonConfirmation1 nonConfd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("confd"), processor, TradeConfirmation5__1.TradeConfirmation5__1Builder.class, getConfd());
			processRosetta(path.newSubPath("nonConfd"), processor, TradeNonConfirmation1.TradeNonConfirmation1Builder.class, getNonConfd());
		}
		

		TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeConfirmation4Choice__1  ***********************/
	class TradeConfirmation4Choice__1Impl implements TradeConfirmation4Choice__1 {
		private final TradeConfirmation5__1 confd;
		private final TradeNonConfirmation1 nonConfd;
		
		protected TradeConfirmation4Choice__1Impl(TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder builder) {
			this.confd = ofNullable(builder.getConfd()).map(f->f.build()).orElse(null);
			this.nonConfd = ofNullable(builder.getNonConfd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("confd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confd")
		public TradeConfirmation5__1 getConfd() {
			return confd;
		}
		
		@Override
		@RosettaAttribute("nonConfd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonConfd")
		public TradeNonConfirmation1 getNonConfd() {
			return nonConfd;
		}
		
		@Override
		public TradeConfirmation4Choice__1 build() {
			return this;
		}
		
		@Override
		public TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder toBuilder() {
			TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder builder) {
			ofNullable(getConfd()).ifPresent(builder::setConfd);
			ofNullable(getNonConfd()).ifPresent(builder::setNonConfd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeConfirmation4Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(confd, _that.getConfd())) return false;
			if (!Objects.equals(nonConfd, _that.getNonConfd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (confd != null ? confd.hashCode() : 0);
			_result = 31 * _result + (nonConfd != null ? nonConfd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeConfirmation4Choice__1 {" +
				"confd=" + this.confd + ", " +
				"nonConfd=" + this.nonConfd +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeConfirmation4Choice__1  ***********************/
	class TradeConfirmation4Choice__1BuilderImpl implements TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder {
	
		protected TradeConfirmation5__1.TradeConfirmation5__1Builder confd;
		protected TradeNonConfirmation1.TradeNonConfirmation1Builder nonConfd;
		
		@Override
		@RosettaAttribute("confd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confd")
		public TradeConfirmation5__1.TradeConfirmation5__1Builder getConfd() {
			return confd;
		}
		
		@Override
		public TradeConfirmation5__1.TradeConfirmation5__1Builder getOrCreateConfd() {
			TradeConfirmation5__1.TradeConfirmation5__1Builder result;
			if (confd!=null) {
				result = confd;
			}
			else {
				result = confd = TradeConfirmation5__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonConfd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonConfd")
		public TradeNonConfirmation1.TradeNonConfirmation1Builder getNonConfd() {
			return nonConfd;
		}
		
		@Override
		public TradeNonConfirmation1.TradeNonConfirmation1Builder getOrCreateNonConfd() {
			TradeNonConfirmation1.TradeNonConfirmation1Builder result;
			if (nonConfd!=null) {
				result = nonConfd;
			}
			else {
				result = nonConfd = TradeNonConfirmation1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("confd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confd")
		@Override
		public TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder setConfd(TradeConfirmation5__1 _confd) {
			this.confd = _confd == null ? null : _confd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonConfd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonConfd")
		@Override
		public TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder setNonConfd(TradeNonConfirmation1 _nonConfd) {
			this.nonConfd = _nonConfd == null ? null : _nonConfd.toBuilder();
			return this;
		}
		
		@Override
		public TradeConfirmation4Choice__1 build() {
			return new TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Impl(this);
		}
		
		@Override
		public TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder prune() {
			if (confd!=null && !confd.prune().hasData()) confd = null;
			if (nonConfd!=null && !nonConfd.prune().hasData()) nonConfd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConfd()!=null && getConfd().hasData()) return true;
			if (getNonConfd()!=null && getNonConfd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder o = (TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder) other;
			
			merger.mergeRosetta(getConfd(), o.getConfd(), this::setConfd);
			merger.mergeRosetta(getNonConfd(), o.getNonConfd(), this::setNonConfd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeConfirmation4Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(confd, _that.getConfd())) return false;
			if (!Objects.equals(nonConfd, _that.getNonConfd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (confd != null ? confd.hashCode() : 0);
			_result = 31 * _result + (nonConfd != null ? nonConfd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeConfirmation4Choice__1Builder {" +
				"confd=" + this.confd + ", " +
				"nonConfd=" + this.nonConfd +
			'}';
		}
	}
}
